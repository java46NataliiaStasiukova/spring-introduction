package telran.spring.calculator.controller;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.validation.Valid;
import telran.spring.calculator.dto.OperationData;
import telran.spring.calculator.service.Operation;

@RestController
@RequestMapping("operationData")
public class CalculatorController {
Map<String, Operation> operations;
List<Operation> operationList;
@Value("${app.operationData.wrong.type:Wrong Type }")
String wrongTypeOperation;
public CalculatorController(List<Operation> operationList) {
	this.operationList = operationList;
}
@PostMapping
String executeOperation(@RequestBody @Valid OperationData operationData) {
	Operation operation = operations.get(operationData.operationName);
	return operation != null ? operation.execute(operationData) :
		wrongTypeOperation + operationData.operationName;
}
@GetMapping
Set<String> getTypes(){
	return operations.keySet();
}
@PostConstruct
void displayTypes() {
    operations = operationList.stream()
            .collect(Collectors.toMap(operation -> operation.getClass().getAnnotation(Component.class).value(),
            		operation -> operation));
	System.out.printf("application context is created with types: %s\n", operations.keySet());
}
@PreDestroy
void shutdown() {
	System.out.println("Buy perform graceful shutdown");
}


}
