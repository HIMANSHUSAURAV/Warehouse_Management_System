package com.jsp.warehouse.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jsp.warehouse.entity.Client;
import com.jsp.warehouse.exception.IllegalOperationException;
import com.jsp.warehouse.repo.ClientRepo;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter{

	
	@Autowired
	private ClientRepo clientRepo;

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if(request.getSession(false) != null) {
			throw new IllegalOperationException("illegal operation ");
		}

		if(!request.getRequestURI().equals("/api/v1/client/register")) {

			String username   = request.getHeader("USERNAME");
			String apiKey   = request.getHeader("API-KEY");

			if(username != null && apiKey != null) {

				Client client=clientRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));	


				if(!apiKey.equals(client.getApiKey()))
					throw new BadCredentialsException("Invalid credentials");
			}
			else { 
				throw new UsernameNotFoundException("User Not Found");
			}
		}
		filterChain.doFilter(request, response);

	}
}
