package com.jvzalves.BoxOfficeSpringBoot.security.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.auth0.jwt.algorithms.Algorithm;
import com.jvzalves.BoxOfficeSpringBoot.DTO.security.TokenDTO;

import jakarta.annotation.PostConstruct;

@Service
public class JwtTokenProvider {
	
	@Value("${security.jwt.token.secret-key:secret}")
	private String secreKey = "secret";

	@Value("${security.jwt.token.exprired-lenght:3600000}")
	private long validityInMilliSeconds= 3600000;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	Algorithm algorithm = null;
	
	@PostConstruct
	protected void init() {
	   secreKey = Base64.getEncoder().encodeToString(secreKey.getBytes());
	   algorithm = Algorithm.HMAC256(secreKey.getBytes());
	}
	
	public TokenDTO createAccessToken(String username, List<String> roles) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMilliSeconds);
		var accessToken = GetAccesseToken(username, roles, now, validity);
		var refreshToken = GetAccesseToken(username, roles, now);
		return new TokenDTO(username, true, now, validity, accessToken, refreshToken);
	}

	private String GetAccesseToken(String username, List<String> roles, Date now) {
		return null;
	}

	private String GetAccesseToken(String username, List<String> roles, Date now, Date validity) {
		return null;
	}
}
