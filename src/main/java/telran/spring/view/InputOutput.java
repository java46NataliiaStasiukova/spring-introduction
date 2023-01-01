package telran.spring.view;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface InputOutput {
	String readString(String prompt);

	void writeObject(Object obj);
	
	default void close() {}

	default void writeLine(Object obj) {
		String str = obj + "\n";
		writeObject(str);
	}

	default <R> R readObject(String prompt, String errorPrompt, Function<String, R> mapper) {
		R result = null;
		while (true) {
			String str = readString(prompt);
			try {
				result = mapper.apply(str);
				break;
			} catch (Exception e) {
				writeLine(errorPrompt + " " + str);//e.getMessage());
			}
		}
		return result;
	}
	
	default Integer readInt(String prompt, String errorPrompt, int min, int max) {
		return readObject(prompt, errorPrompt, s -> {
			int num = Integer.parseInt(s);
			if (num < min) {
				throw new RuntimeException("less than " + min);
			}
			if (num > max) {
				throw new RuntimeException("greater than " + max);
			}
			return num;
			
		});
	}
	
	default String readOption (String prompt, String errorPrompt, List<String> options ) {
		return readPredicate(prompt, errorPrompt, options::contains);
	}
	
	default String readPredicate(String prompt, String errorPrompt, 
			Predicate<String> predicate) {
		return readObject(prompt, errorPrompt, s -> {
			if (!predicate.test(s)) {
				throw new RuntimeException();
			}
			return s;
		});
	}

	
	
}