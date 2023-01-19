package telran.spring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import telran.spring.calculator.dto.*;
import telran.spring.calculator.service.*;

@SpringBootTest
class CalculatorServicesTest {

@Autowired
ArithmeticSimpleOperation arithmeticOperation;
@Autowired
DatesBetweenOperation datesBetweenOperation;
@Autowired
DatesSimpleOperation datesOperation;

	@Test
	void arithmeticOperationTest() {
		ArithmeticOperationData data = new ArithmeticOperationData();
		data.operationName = "arithmetic";
		data.additionalData = "+";
		data.operand1 = (double) 20;
		data.operand2 = (double) 25;
		assertTrue(arithmeticOperation.execute(data).contains("45"));
	}
	
	@Test
	void arithmeticOperationWrongDtoTest() {
		ArithmeticOperationData data = new ArithmeticOperationData();
		data.operationName = "arithmetic";
		data.additionalData = "?";
		data.operand1 = (double) 20;
		data.operand2 = (double) 25;
		assertTrue(arithmeticOperation.execute(data).contains("Wrong arithmetic operation"));
	}
	
	@Test
	void datesOperationTest() {
		DataDaysOperationData data = new DataDaysOperationData();
		data.operationName = "dates";
		data.additionalData = "before";
		data.date = "2022-12-12";
		data.days = 5;
		assertTrue(datesOperation.execute(data).contains("2022-12-07"));
	}
	
	@Test
	void datesOperationWrongDtoTest() {
		DataDaysOperationData data = new DataDaysOperationData();
		data.operationName = "dates";
		data.additionalData = "";
		data.date =  "2022-12-12";
		data.days = -5;
		assertTrue(datesOperation.execute(data).contains(""));
	}
	
	@Test
	void datesBetweenOperationTest() {
		DatesOperationData data = new DatesOperationData();
		data.operationName = "dates-between";
		data.additionalData = "";
		data.dateFrom = "2022-12-12";
		data.dateTo = "2022-12-14";
		assertTrue(datesBetweenOperation.execute(data).contains("2"));
	}
	
	@Test
	void datesBetweenOperationWrongDtoTest() {
		DatesOperationData data = new DatesOperationData();
		data.operationName = "dates-betweennnn";
		data.additionalData = "";
		data.dateFrom = "2022-12-12";
		data.dateTo = "2022-12-14";
		assertTrue(datesBetweenOperation.execute(data).contains(""));
	}

}
