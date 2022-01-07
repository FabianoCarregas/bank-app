package com.fabiano.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fabiano.enums.UserProfile;

public class UserSS {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS() {
	}
	
	public UserSS(Long id, String email, String password, Set<UserProfile> profiles) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.authorities = profiles.stream().map(x -> new SimpleGrantedAuthority(x.getDescription())).collect(Collectors.toList());
	}
	
	public Long getId() {
		return id;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public boolean hasRole(UserProfile profile) {
		return getAuthorities().contains(new SimpleGrantedAuthority(profile.getDescription()));
		
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	

}