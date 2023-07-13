package gov.naco.soch.aop;

import java.util.Collections;
import java.util.HashMap;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import gov.naco.soch.config.Constants;
import gov.naco.soch.enums.NotificationEventId;
import gov.naco.soch.service.NotificationService;

@Component
@EnableAsync
@Aspect
public class NotificationAspect {
	@Value("${accessKey}")
	private String access;
	private final NotificationService notificationService;
	
	public NotificationAspect(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	@Async
	public void beneficiaryArtReferralNotification(Long facilityId, String token) {
		HashMap<String, Object> placeholderMap = new HashMap<>();
		placeholderMap.put(Constants.NOTIFICATION_PLACEHOLDER_FACILITY, facilityId);
		placeholderMap.put(Constants.ACCESS_KEY, access);
		sendNotfication(NotificationEventId.ICTC_ART_REFERRAL.getEventId(), false, false, false, true, token,
				placeholderMap);
	}
	
	private void sendNotfication(String eventId, boolean emailToBeSent, boolean smsToBeSent, boolean whatsAppToBeSent, boolean webNotification, String token, HashMap<String, Object> placeholderMap) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setBearerAuth(token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<HashMap<String, Object>> request = new HttpEntity<HashMap<String, Object>>(placeholderMap, headers);
		if(webNotification) {
			notificationService.sendWebNotification(eventId, request);
		}
		if(emailToBeSent) {
			notificationService.sendEmail(eventId, request);
		}
		if(smsToBeSent) {
			notificationService.sendSMS(eventId, request);
		}
		if(whatsAppToBeSent) {
			notificationService.sendWhatsAppMessage(eventId, request);
		}
	}
	

}
