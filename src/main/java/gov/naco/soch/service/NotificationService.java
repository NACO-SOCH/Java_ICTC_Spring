package gov.naco.soch.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import gov.naco.soch.aop.NotificationAspect;

@Service
@EnableAsync
public class NotificationService {

	private final RestTemplate restTemplate;
	
	private final Logger log = LoggerFactory.getLogger(NotificationAspect.class);
	
	@Value("${notification.emailServiceUrl}")
	private String EMAIL_ENDPOINTURL;
	
	@Value("${notification.smsServiceUrl}")
	private String SMS_ENDPOINTURL;
	
	@Value("${notification.whatsappServiceUrl}")
	private String WHATSAPP_ENDPOINTURL;
	
	@Value("${notification.webuserNotificationUrl}")
	private String WEB_ENDPOINTURL;
	
	public NotificationService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Async
	public void sendEmail(String eventId, HttpEntity<HashMap<String, Object>> request) {
		try {
			log.info("Going to send email for the eventId-->{}:", eventId);
			restTemplate.exchange(EMAIL_ENDPOINTURL.concat(eventId), HttpMethod.POST, request, HashMap.class);
			log.info("Sent the email for the eventId-->{}:", eventId);
		} catch (Exception e) {
			log.error("EXCEPTION in sendEmail", e);
		}
	}
	
	@Async
	public void sendSMS(String eventId, HttpEntity<HashMap<String, Object>> request) {
		try {
			log.info("Going to send sms for the eventId-->{}:", eventId);
			restTemplate.exchange(SMS_ENDPOINTURL.concat(eventId), HttpMethod.POST, request, HashMap.class);
			log.info("Sent sms for the eventId-->{}:", eventId);
		} catch (Exception e) {
			log.error("EXCEPTION in sendSMS", e);
		}
	}
	
	@Async
	public void sendWhatsAppMessage(String eventId, HttpEntity<HashMap<String, Object>> request) {
		try {
			log.info("Going to send whatsapp for the eventId-->{}:", eventId);
			restTemplate.exchange(WHATSAPP_ENDPOINTURL.concat(eventId), HttpMethod.POST, request, HashMap.class);
			log.info("Sent whatsapp for the eventId-->{}:", eventId);
		} catch (Exception e) {
			log.error("EXCEPTION in sendWhatsApp", e);
		}
	}
	
	@Async
	public void sendWebNotification(String eventId, HttpEntity<HashMap<String, Object>> request) {
		try {
			log.info("Going to send web user notification for the eventId-->{}:", eventId);
			restTemplate.exchange(WEB_ENDPOINTURL.concat(eventId), HttpMethod.POST, request, HashMap.class);
			log.info("Sent  web user notification for the eventId-->{}:", eventId);
		} catch (Exception e) {
			log.error("EXCEPTION in web user notification", e);
		}
	}
}
