package telran.spring.calculator.dto;

import jakarta.validation.constraints.*;

public class DataDaysOperationData extends  OperationData{
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
	public String date;
	@Positive @NotNull
	public Integer days;
}
