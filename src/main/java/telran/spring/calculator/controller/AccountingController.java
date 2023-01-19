package telran.spring.calculator.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;

import telran.spring.calculator.dto.Account;

@RestController
@RequestMapping("accounts")
public class AccountingController {
	PasswordEncoder encoder;
	UserDetailsManager manager;
	public AccountingController(PasswordEncoder encoder, UserDetailsManager manager) {
		this.encoder = encoder;
		this.manager = manager;
	}
	@PostMapping
	String addUser(@RequestBody Account account) {
		String res = String.format("User with name %s already exists", account.userName);
		if(!manager.userExists(account.userName)) {
			manager.createUser(User.withUsername(account.userName)
					.password(encoder.encode(account.password)).roles(account.role).build());
			res = String.format("user %s has been added", account.userName);
		}
		return res;
		
	}
	@PutMapping
	String updateUser(@RequestBody Account account) {
		
		String res = String.format("User with name %s doesn't exist", account.userName);
		if(manager.userExists(account.userName)) {
			manager.updateUser(User.withUsername(account.userName)
					.password(encoder.encode(account.password)).roles(account.role).build());
			res = String.format("user %s has been updated", account.userName);
			//
		}
		return res;
	}
	@DeleteMapping("/{username}")
	String deleteUser(@PathVariable("username") String username) {
		String res = String.format("User with name %s doesn't exist", username);
		if(manager.userExists(username)) {
			manager.deleteUser(username);
			res = String.format("user %s has been deleted", username);
		}
		return res;
	}
	@GetMapping("/{username}")
	boolean userExists(@PathVariable("username") String username) {
		return manager.userExists(username);
	}
	
	
	
}
