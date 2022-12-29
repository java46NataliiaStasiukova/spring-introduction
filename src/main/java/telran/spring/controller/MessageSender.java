package telran.spring.controller;

import java.util.*;

import org.springframework.stereotype.Component;

import telran.spring.service.Sender;
@Component
public class MessageSender {
Map<String, Sender> senders;
public MessageSender(Map<String, Sender> senders) {
		this.senders = senders;
	}

public void menu() {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	String line;
	while(true) {
		System.out.printf("enter type from %s or exit\n", getTypes());
		line = scanner.nextLine();
		if(line.equalsIgnoreCase("exit")) {
			break;
		}
		Sender sender = senders.get(line);
		if(sender == null) {
			System.out.println(line + " type doesn't exist");
		} else {
			System.out.println("enter text");
			line = scanner.nextLine();
			sender.send(line);
		}
	}
}
private Set<String> getTypes() {
	
	return senders.keySet();
}
}
