package com.jvzalves.filmlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvzalves.filmlist.DTO.security.AccountCredentialsDTO;
import com.jvzalves.filmlist.services.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Authetication Endpoint")
@RestController
@RequestMapping("/auth") 
public class AuthController {
	
	@Autowired
	private AuthService authService; 
	
	@SuppressWarnings("rawtypes")
	@Operation(summary = "Authenticates a user and returns a token")
	@PostMapping( value = "/signin")
	public ResponseEntity signin(@RequestBody AccountCredentialsDTO dto) {
		if (checkIfParamsIsNotNull(dto))
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client resquest");
		var token = authService.signin(dto);
		if (token == null)
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
		return token;
	}

	private boolean checkIfParamsIsNotNull(AccountCredentialsDTO dto) {
		return dto == null || dto.getUserName() == null || dto.getUserName().isBlank() 
				||  dto.getPassword() == null || dto.getPassword().isBlank();
	}
}

