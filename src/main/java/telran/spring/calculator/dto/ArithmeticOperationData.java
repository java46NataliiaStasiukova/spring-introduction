package telran.spring.calculator.dto;

import jakarta.validation.constraints.*;

public class ArithmeticOperationData extends  OperationData{
	@NotNull
	public Double operand1;
	@NotNull
	public Double operand2;
}
