package telran.spring;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import telran.spring.calculator.controller.CalculatorController;
import telran.spring.calculator.security.SecurityConfiguration;


@WebMvcTest(CalculatorController.class)
@Import(SecurityConfiguration.class)
class CalculatorSecurityTest {
	@Autowired
	MockMvc mockMvc;


	@Test
	void rightAuthentication() throws Exception {
		mockMvc.perform(post("http://localhost:8080/calculator")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{}").with(user("admin").roles("ADMIN"))
				).andExpect(status().isBadRequest());
	}
	
	@Test
	void wrongAuthentication() throws Exception {
		mockMvc.perform(post("http://localhost:8080/calculator")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{}"))
				.andExpect(status().isUnauthorized());//is(401)
	}
	
	@Test
	void wrongAuthorization() throws Exception {
		mockMvc.perform(post("http://localhost:8080/calculator")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{}").with(user("user"))
				).andExpect(status().isForbidden());//is(403)
	}

}
