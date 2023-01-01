package telran.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import telran.spring.service.Message;
import telran.spring.service.MessageTypes;
import telran.spring.view.*;

@SpringBootApplication
public class SpringArchitectureApplication {
	static ConfigurableApplicationContext ct;
	public static void main(String[] args) {
		ct = SpringApplication.run(SpringArchitectureApplication.class, args);
		Menu menu = new Menu("Message sender", getItems());
		menu.perform(new ConsoleInputOutput());	
		ct.close();
	}

	private static Item[] getItems() {
		Item[] res = {
				Item.of("Send message", SpringArchitectureApplication::sendMessage),
				Item.exit()
		};
		return res;
	}
	
	private static void sendMessage(InputOutput io) {
		String messageType = io.readOption("Enter message type: " + MessageTypes.getTypes(),
				"Wrong option", MessageTypes.getTypes());
		io.writeLine(messageType);
		Message message = (Message) ct.getBean(messageType);
		String text = io.readString("Enter text");
		message.send(io, text);
	}

}