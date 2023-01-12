package telran.spring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import telran.spring.calculator.dto.*;
import telran.spring.calculator.service.*;

@SpringBootTest
class CalculatorOperationsTest {
@Autowired
Map<String, Operation> operationService;


	@Test
	void arithmeticSimpleTest() {
		Operation operation = operationService.get("arithmeticSimpleOperation");
		ArithmeticOperationData data = new ArithmeticOperationData();
		data.additionalData = "*";
		data.operand1 = 10.0;
		data.operand2 = 2.0;
		assertEquals("20.0", operation.execute(data));
	}
	
	@Test
	void datesSimpleTest() {
		Operation operation = operationService.get("arithmeticSimpleOperation");
		DatesOperationData data = new DatesOperationData();
		assertTrue(operation.execute(data).contains("Wrong"));
	}

}
