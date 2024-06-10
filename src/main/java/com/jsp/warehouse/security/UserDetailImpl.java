package com.jsp.warehouse.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jsp.warehouse.entity.Admin;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailImpl implements UserDetails {

	@Autowired
	private Admin admin;

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		admin.getAdminType()
		.getPrivileges().stream()
		.map(privilege -> 
		new SimpleGrantedAuthority(
				privilege.name()))
		.toList();
		
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return admin.getAdminEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}


