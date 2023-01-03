package telran.spring.service;

import org.springframework.stereotype.Service;

import telran.spring.dto.*;

@Service("tcp")
public class TcpSender implements Sender {

	@Override
	public String send(Message message) {
		TcpMessage tcpMessage = (TcpMessage) message;
		
		return String.format("TCP sender text '%s' has been sent to %s:%d\n",tcpMessage.text,
				tcpMessage.ipAddress, tcpMessage.port);

	}
	

}
