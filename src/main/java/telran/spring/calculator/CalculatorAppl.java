package telran.spring.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import telran.spring.SpringArchitectureApplication;

public class CalculatorAppl {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ct = 
				SpringApplication.run(SpringArchitectureApplication.class, args);
	}
}