package telran.spring.service;

import org.springframework.stereotype.Service;

@Service("sms")
public class SmsSender implements Sender {

	@Override
	public void send(String text) {
		System.out.printf("SMS message: %s has been sent\n", text);

	}

}
