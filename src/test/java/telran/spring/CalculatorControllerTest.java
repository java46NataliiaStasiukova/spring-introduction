package telran.spring;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import telran.spring.calculator.controller.*;
import telran.spring.calculator.dto.*;
import telran.spring.calculator.security.SecurityConfiguration;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(CalculatorController.class)
@Import(SecurityConfiguration.class)
@WithMockUser(roles= {"USER", "ADMIN"})
class CalculatorControllerTest {
	@Autowired
	MockMvc mockMvc;
	ObjectMapper mapper = new ObjectMapper();

	@Test
	void rightDataControllerTest() throws Exception {
		ArithmeticOperationData data = new ArithmeticOperationData();
		data.operationName = "arithmetic";
		data.additionalData = "+";
		data.operand1 = (double) 20;
		data.operand2 = (double) 25;
		String messageJSON = mapper.writeValueAsString(data);
		mockMvc.perform(post("http://localhost:8080/operationData")
				.contentType(MediaType.APPLICATION_JSON)
				.content(messageJSON)).andExpect(status().isOk());
	}

	@Test
	void wrongDataControllerTest() throws Exception {
		ArithmeticOperationData data = new ArithmeticOperationData();
		data.operationName = "arithmetic";
		data.additionalData = "+";
		
		data.operand2 = (double) 25;
		String messageJSON = mapper.writeValueAsString(data);
		mockMvc.perform(post("http://localhost:8080/operationData")
				.contentType(MediaType.APPLICATION_JSON)
				.content(messageJSON)).andExpect(status().isBadRequest());
	}
	
	@Test
	void getMappingControllerTest() throws Exception {
		this.mockMvc.perform(get("http://localhost:8080/operationData"))
		.andExpect(status().isOk());
		//.andExpect(content().string(containsString("arithmetic")));
		
	}
	
	@Test
	void getMappingFailedTest() throws Exception {
	    mockMvc.perform(get("http://localhost:8080/wrongData"))
	        .andExpect(status().isNotFound());
	}

}
