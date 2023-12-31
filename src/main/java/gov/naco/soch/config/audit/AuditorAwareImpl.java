package gov.naco.soch.config.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import gov.naco.soch.security.UserAuthenticationToken;

public class AuditorAwareImpl implements AuditorAware<Long> {

	@Override
	public Optional<Long> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		try {
			Long userId = !(authentication instanceof AnonymousAuthenticationToken)
					? ((UserAuthenticationToken) authentication).getUserId()
					: 0L;

			return Optional.of(userId);
		} catch (Exception e) {
			return Optional.of(0L);
		}
	}

}
