package telran.spring.calculator.service;

import org.springframework.stereotype.Service;
import java.lang.reflect.Method;

import telran.spring.calculator.dto.ArithmeticOperationData;
import telran.spring.calculator.dto.OperationData;
@Service("arithmetic")
public class ArithmeticSimpleOperation implements Operation{
	@Override
	public String execute(OperationData data) {
		ArithmeticOperationData arithmeticData = (ArithmeticOperationData) data;
		Method method = null;
		String res;
			try {
				method = this.getClass().getDeclaredMethod(arithmeticData.additionalData,
						double.class, double.class);
				res = (String) method.invoke(this, new Object[] {arithmeticData.operand1, arithmeticData.operand2});
			} catch (Exception e) {
				res = "Wrong operation";
			}
			return res.toString();
	}
	
	String divide(double op1, double op2) {
		if((int)op2 == 0) {
			return "Dividing by zero";
		}
		return String.format("%s divade %s = %s\n", op1, op2, (op1 / op2));
	}

	String multiply(double op1, double op2) {
		
		return String.format("%s multiply %s = %s\n", op1, op2, (op1 * op2));
	}

	String subtract(double op1, double op2) {
		
		return String.format("%s substract %s = %s\n", op1, op2, (op1 - op2));
	}

	String add(double op1, double op2) {
		
		return String.format("%s add %s = %s\n", op1, op2, (op1 + op2));
	}
	
}
