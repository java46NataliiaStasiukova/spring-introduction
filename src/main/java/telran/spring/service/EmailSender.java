package telran.spring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import telran.spring.dto.*;
//logging.level.root=log
@Service
@Component("email")
public class EmailSender implements Sender {

	@Override
	public String send(Message message) {
		String res = "";
		
		EmailMessage emailMessage;
		try {
			emailMessage = (EmailMessage) message;
			res = String.format("email sender text '%s' has been sent to %s\n", emailMessage.text,
					emailMessage.emailAddress);
			LOG.debug("message: {}", res);
		} catch (Exception e) {
			res = "Message Data mismatch sender type";
			LOG.error("Exception {}", e);
		}
		return res;

	}



}