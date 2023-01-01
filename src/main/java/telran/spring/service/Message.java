package telran.spring.service;

import telran.spring.view.InputOutput;

public interface Message {
	
	void send(InputOutput io, String text);

}