package telran.spring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import telran.spring.dto.*;
import telran.spring.service.*;

@SpringBootTest
class MessageServicesTets {
@Autowired
EmailSender emailSender;
@Autowired
SmsSender smsSender;
@Autowired
TcpSender tcpSender;

	
	@Test
	void emailSenderTest() {
		//TcpMessage message = new TcpMessage();
		EmailMessage message = new EmailMessage();
		message.type = "email";
		message.text = "any text";
		message.emailAddress = "telran@gmail.com";
		assertTrue(emailSender.send(message).contains("email sender"));
	}

}
