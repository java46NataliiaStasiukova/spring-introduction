package telran.spring.calculator.service;

import org.slf4j.*;

import telran.spring.calculator.dto.OperationData;

public interface Operation {
	
	static Logger LOG = LoggerFactory.getLogger(Operation.class);
	
	public static final String wrongDtoMessage = "Wrong type; class cast exception";
	
	String execute(OperationData data);
	
	String getName();
	
}
