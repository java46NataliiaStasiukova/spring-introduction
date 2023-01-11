package telran.spring.calculator.controller;
import java.util.*;
//logging.level.telran=debug
import java.util.stream.Collectors;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
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
static Logger LOG = LoggerFactory.getLogger(CalculatorController.class);
public CalculatorController(List<Operation> operationList, Map<String, Operation> operations) {
	this.operationList = operationList;
	this.operations = operations;
}
@PostMapping
String executeOperation(@RequestBody @Valid OperationData operationData) {
	LOG.debug("received request for operation name: {}, with additional operation data: {}",
			operationData.operationName, operationData.additionalData);
	Operation operation = operations.get(operationData.operationName);
	return operation != null ? operation.execute(operationData) :
		wrongTypeOperation + operationData.operationName;
}
@GetMapping
Set<String> getTypes(){
	LOG.info("request for getting operation types: {}", operations.keySet());
	return operations.keySet();
}
@PostConstruct
void displayTypes() {
//    operations = operationList.stream()
//            .collect(Collectors.toMap(Operation::getName, service -> service));
    LOG.info("application context is created with types {}", operations.keySet());
}
@PreDestroy
void shutdown() {
	LOG.info("shutdown performed");
}


}
