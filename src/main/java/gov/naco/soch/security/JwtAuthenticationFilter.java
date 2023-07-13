package gov.naco.soch.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gov.naco.soch.config.Constants;
import gov.naco.soch.exception.ServiceAuthException;
import gov.naco.soch.repository.UserAuthRepository;
import gov.naco.soch.service.dto.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Autowired
	private UserAuthRepository userAuthRepository;

	private static String[] tokenChecksafeUrls = { "auth/login", "captcha/load", "auth/delete/sid", "system/details",
			"system/clearCache", "mhl", "/management" };
	private static String[] activeTokenCheckSafeUrls = { "/admin/master","api/minimasters" };
	//private static String[] activeTokenCheckSafeUrls = { "/admin/master", "admin/facility/listby","api/minimasters" };

	private Set<String> skipUrls = new HashSet<>(Arrays.asList("/swagger-ui.html", "/v2/api-docs", "/webjars/**",
			"/swagger-resources/**", "/user/login", "/api/test", "/api/run/batch"));

	private AntPathMatcher pathMatcher = new AntPathMatcher();

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		return skipUrls.stream().anyMatch(p -> pathMatcher.match(p, request.getServletPath()));
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String username = null;
		try {
			log.info("Got the request-->{}:", req.getRequestURI());
			String header = req.getHeader(Constants.HEADER_STRING);
			List<String> detailsSimplified = new ArrayList<String>();
			ErrorResponse errorResponse = new ErrorResponse();
			String authToken = null;
			if (Arrays.stream(tokenChecksafeUrls).parallel().anyMatch(req.getRequestURI()::contains)) {
				log.debug("No need to validate token as URL is in safe list");
				chain.doFilter(req, res);
			} else {
				if (header != null && header.startsWith(Constants.TOKEN_PREFIX)) {
					authToken = jwtTokenUtil.getTokenFromHeader(header);
					try {
						username = jwtTokenUtil.getUsernameFromToken(authToken);
						log.info("Prcessing request --> username-->{}:request-->{}:", username, req.getRequestURI());
					} catch (IllegalArgumentException e) {
						log.error("An error occured during getting username from token", e);
						detailsSimplified.add(e.getMessage());
						errorResponse.setMessage("An error occured during getting username from token");
						errorResponse.setDetailsSimplified(detailsSimplified);
						res.setStatus(HttpStatus.UNAUTHORIZED.value());
						res.setContentType(MediaType.APPLICATION_JSON_VALUE);
						res.getWriter().write(convertObjectToJson(errorResponse));
						return;
					} catch (ExpiredJwtException e) {
						log.warn("The token is expired and not valid anymore", e);
						detailsSimplified.add(e.getMessage());
						errorResponse.setMessage("The token is expired and not valid anymore");
						errorResponse.setDetailsSimplified(detailsSimplified);
						res.setStatus(HttpStatus.UNAUTHORIZED.value());
						res.setContentType(MediaType.APPLICATION_JSON_VALUE);
						res.getWriter().write(convertObjectToJson(errorResponse));
						return;
					} catch (SignatureException e) {
						log.error("Authentication Failed. Invalid token!!");
						detailsSimplified.add(e.getMessage());
						errorResponse.setMessage("Authentication Failed. Invalid token!!");
						errorResponse.setDetailsSimplified(detailsSimplified);
						res.setStatus(HttpStatus.UNAUTHORIZED.value());
						res.setContentType(MediaType.APPLICATION_JSON_VALUE);
						res.getWriter().write(convertObjectToJson(errorResponse));
						return;
					}
				} else {
					log.error("Authentication Failed. No token!!");
					detailsSimplified.add("Authentication Failed. No token!!");
					errorResponse.setMessage("Authentication Failed. Invalid token!!");
					errorResponse.setDetailsSimplified(detailsSimplified);
					res.setStatus(HttpStatus.UNAUTHORIZED.value());
					res.setContentType(MediaType.APPLICATION_JSON_VALUE);
					res.getWriter().write(convertObjectToJson(errorResponse));
					return;

				}
				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

					if (jwtTokenUtil.validateToken(authToken)) {
						List<String> accessCodes = (List<String>) jwtTokenUtil.getClaimsFromToken(authToken)
								.get("accessCodes");
						Long userId = ((Integer) jwtTokenUtil.getClaimsFromToken(authToken).get("userId")).longValue();

						String activeKey = (String) jwtTokenUtil.getClaimsFromToken(authToken).get("activeKey");

						boolean activeTokenCheckNeeded = Arrays.stream(activeTokenCheckSafeUrls).parallel()
								.anyMatch(req.getRequestURI()::contains) ? false : true;
						String activeToken = null;
						//activeTokenCheckNeeded = false; // TODO: Need to remove
						if (activeTokenCheckNeeded) {
							activeToken = userAuthRepository.findActiveTokenByUserId(userId);
						}

						if (!activeTokenCheckNeeded || (activeKey != null && !StringUtils.isBlank(activeToken)
								&& activeKey.contentEquals(activeToken)
								)) {

							List<SimpleGrantedAuthority> authorityList = accessCodes.stream()
									.map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());

							UsernamePasswordAuthenticationToken authentication = new UserAuthenticationToken(username,
									null, userId, authToken, authorityList);
							authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
							log.debug("authenticated user " + username + ", setting security context");
							SecurityContextHolder.setStrategyName("MODE_INHERITABLETHREADLOCAL");
							SecurityContextHolder.getContext().setAuthentication(authentication);
						} else {
							log.error(
									"EXCEPTION in JwtAuthenticationFilter.doFilterInternal activeToken match failed -->Unauthorised access or Session Ended-->username-->{}:Endpoint-->{}:activeTokenCheckNeeded-->{}:activeKey-->{}:activeToken-->{}:",
									username, req.getRequestURI(), activeTokenCheckNeeded, activeKey, activeToken);
							/*
							 * System.out.println(
							 * "EXCEPTION in JwtAuthenticationFilter.doFilterInternal activeToken match failed -->Unauthorised access or Session Ended-->username-->"
							 * + username + ":Endpoint-->" + req.getRequestURI() +
							 * ":activeTokenCheckNeeded-->" + activeTokenCheckNeeded + ":activeKey-->" +
							 * activeKey + ":activeToken-->" + activeToken);
							 */
							throw new ServiceAuthException("Unauthorised access or Session Ended");
						}
					}
				}

				chain.doFilter(req, res);
			}

		} catch (ServiceAuthException e) {
			log.error(
					"EXCEPTION -->ServiceAuthException in JwtAuthenticationFilter.doFilterInternal for user-->{}:request-->{}:",
					username, req.getRequestURI(), e);
			res.setStatus(HttpStatus.UNAUTHORIZED.value());
			res.getWriter().write(e.getMessage());
		} catch (Exception e) {
			log.error("EXCEPTION in JwtAuthenticationFilter.doFilterInternal for user-->{}:request-->{}:", username,
					req.getRequestURI(), e);
			res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.getWriter().write(e.getMessage());
		}
	}

	private String convertObjectToJson(Object object) throws JsonProcessingException {
		if (object == null) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}

}