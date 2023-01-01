package telran.spring.service;

import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class MessageTypes {
	static Map<String, Message> options;
	public MessageTypes(Map<String, Message> options) {
		MessageTypes.options = options;
	}

	public static List<String> getTypes() {
		
		return new ArrayList<>(options.keySet());
	}
}