package telran.spring.calculator;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import telran.spring.SpringArchitectureApplication;

public class CalculatorAppl {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ct = 
				SpringApplication.run(SpringArchitectureApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("for shutdown type 'exit'");
			String line = scanner.nextLine();
			if(line.equalsIgnoreCase("exit")) {
				break;
			}
		}
		ct.close();
		scanner.close();
	}
}
