package telran.spring.service;

import org.springframework.stereotype.Service;

import telran.spring.view.InputOutput;

@Service("email")
public class EmailMessage implements Message{
	//Usage: telran@java.com
	@Override
	public void send(InputOutput io, String message) {
		String email = io.readPredicate("Enter email address", "Email not correct",
				p -> p.matches(getRegex()));
		io.writeObject(email);
		System.out.printf("\nemail message '%s' has been sent to email address %s\n", message, email);
		
	}

	private String getRegex() {
		String regex = "^(?=.{1,64}@)[\\p{L}0-9\\+_-]+(\\.[\\p{L}0-9\\+_-]+)*@{0}"
		        + "[^-][\\p{L}0-9\\+-]+(\\.[\\p{L}0-9\\+-]+)*(\\.[\\p{L}]{2,})$";
		return regex;
	}



}