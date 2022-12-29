package telran.spring.service;

import org.springframework.stereotype.Service;

@Service("whatsup")
public class WhatsupMessage implements Sender{

	@Override
	public void send(String text) {
		System.out.printf("What's up message: %s has been sent\n", text);
	}

}
