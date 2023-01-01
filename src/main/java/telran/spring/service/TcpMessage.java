package telran.spring.service;

import org.springframework.stereotype.Service;

import telran.spring.view.InputOutput;


@Service("tcp")
public class TcpMessage implements Message {
	//Usage: 250.0.199.249
	@Override
	public void send(InputOutput io, String message) {
		String ipPort = io.readPredicate("Enter ipv4 port", "ipv4:port not correct", 
				p -> p.matches(getRegex()));
		io.writeObject(ipPort);
		System.out.printf("\ntcp message '%s' has been sent to ip:port %s\n", message, ipPort );
		
	}
	

	private String getRegex() {
		String ipRegex = "\\d\\d?|[0,1]\\d\\d|2[0-4]\\d|25[0-5]";
		String res = String.format("((%s)\\.){3}(%s)", ipRegex, ipRegex);
		return res;
	}


}