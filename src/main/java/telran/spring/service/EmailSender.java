package telran.spring.service;

import org.springframework.stereotype.Service;

import telran.spring.dto.*;

@Service("email")

public class EmailSender implements Sender {

	@Override
	public String send(Message message) {
		EmailMessage emailMessage = (EmailMessage) message;

		return String.format("email sender text '%s' has been sent to %s\n", emailMessage.text,
				emailMessage.emailAddress);

	}

}
