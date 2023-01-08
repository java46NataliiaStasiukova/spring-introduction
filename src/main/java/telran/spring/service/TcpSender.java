package telran.spring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import telran.spring.dto.*;

@Service
@Component("tcp")
public class TcpSender implements Sender {

	@Override
	public String send(Message message) {
		String res = "";
		TcpMessage tcpMessage;
		try {
			tcpMessage = (TcpMessage) message;
			res = String.format("TCP sender text '%s' has been sent to %s:%d\n",tcpMessage.text,
					tcpMessage.ipAddress, tcpMessage.port);
		} catch (Exception e){
			res = "Message Data mismatch sender type";
		}
		
		return res;
	}
}
