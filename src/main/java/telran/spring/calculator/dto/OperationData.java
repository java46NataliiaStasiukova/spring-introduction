package telran.spring.calculator.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({@Type(ArithmeticOperationData.class),
	@Type(DataDaysOperationData.class),
	@Type(DatesOperationData.class)})
public class OperationData {
	public String operationName;
	public String additionalData;
}
