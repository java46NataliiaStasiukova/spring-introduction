package telran.spring.service;

import org.springframework.stereotype.Service;

@Service("tcp")
public class TcpSender implements Sender {

	@Override
	public void send(String text) {
		System.out.printf("TCP message: %s has been sent\n", text);

	}

}
