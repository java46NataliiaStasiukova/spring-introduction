package telran.spring.calculator.service;

import org.springframework.stereotype.*;
import java.util.*;
import java.util.function.BiFunction;

import telran.spring.calculator.dto.ArithmeticOperationData;
import telran.spring.calculator.dto.OperationData;
@Service
public class ArithmeticSimpleOperation implements Operation {
private static Map<String, BiFunction<Double, Double, String>> operations;
static {
	operations = new HashMap<>();
	operations.put("*", (o1, o2) -> o1 * o2 + "");
	operations.put("-", (o1, o2) -> o1 - o2 + "");
	operations.put("+", (o1, o2) -> o1 + o2 + "");
	operations.put("/", (o1, o2) -> o1 / o2 + "");
	
}
	@Override
	public String execute(OperationData data) {
		String res = "";
		ArithmeticOperationData arithmeticData;
		try {
			arithmeticData = (ArithmeticOperationData) data;
			var function = operations.getOrDefault(data.additionalData,
					(o1, o2) -> "Wrong arithmetic operation should be (*,/,+,-)");
			res = function.apply(arithmeticData.operand1, arithmeticData.operand2);
			LOG.debug("result message: {}", res);
		} catch (ClassCastException e) {
			res = wrongDtoMessage;
			LOG.error("error: {}", res);
		}
		
		return res;
	}
	@Override
	public String getName() {
		
		return "arithmetic";
	}
	
}
