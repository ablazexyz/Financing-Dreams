package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Login;
import com.lti.model.Registration;
import com.lti.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping(path = "users")
// http://localhost:9091/HomeApp/users
public class UserController {

	@Autowired
	private CustomerService service;

	// http://localhost:9091/HomeApp/users/adlogin
	@PostMapping(path = "adlogin")
	public ResponseEntity<String> loginadmin(@RequestBody Login login) {

		boolean result = service.verifyAdLogin(login);
		if (result) {
			return ResponseEntity.ok("Login Success");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// http://localhost:9091/HomeApp/users/login
	@PostMapping(path = "login")
	public ResponseEntity<String> loginuser(@RequestBody Login login) {

		boolean result = service.verifyLogin(login);
		if (result) {
			return ResponseEntity.ok("Login Success");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// http://localhost:9091/HomeApp/users/register
	@PostMapping(path = "register")
	public ResponseEntity<String> registerUser(@RequestBody Registration reg) {

		try {
			service.findRegistrationDetailsbyEmail(reg.getEmailId());
			return ResponseEntity.notFound().build();
		}
		catch(Exception e) {
			service.createRegistration(reg);
		}
		return null;
	}

	@GetMapping(path = "/")
	public List<Registration> getUserList() {

		return service.findAllRegistrations();
	}
	
	@GetMapping(path = "isFirstTimeUser/{email}")
	public boolean isFirstTimeUser(@PathVariable(name = "email") String email) {
		return service.isFirstTimeUser(email);
	}
}
