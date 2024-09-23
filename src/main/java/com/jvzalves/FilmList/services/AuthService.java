package com.jvzalves.filmlist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jvzalves.filmlist.DTO.security.AccountCredentialsDTO;
import com.jvzalves.filmlist.DTO.security.TokenDTO;
import com.jvzalves.filmlist.repositories.UserRepository;
import com.jvzalves.filmlist.security.jwt.JwtTokenProvider;

@Service
public class AuthService {
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity signin(AccountCredentialsDTO account) {
		try {
			var username = account.getUserName();
			var passowrd = account.getPassword();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, passowrd));
			
			var user = userRepository.findByUserName(username);
			var tokenResponse = new TokenDTO();

			if (user != null) {
			    tokenResponse = jwtTokenProvider.createAccessToken(username, user.getRoles());
			} else {
				throw new UsernameNotFoundException("Username " + username + "not found!" );
			}
			return ResponseEntity.ok(tokenResponse);
		} catch (Exception e) {
			throw new BadCredentialsException("Invalide username/password supplied!");
		}
	}
}
