package com.collaboration.AssignmentBackend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Authorities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private int authoritiesId;
    private String username;
    private String role;
    
    public Authorities() {
		// TODO Auto-generated constructor stub
	}

	public int getAuthoritiesId() {
		return authoritiesId;
	}

	public void setAuthoritiesId(int authoritiesId) {
		this.authoritiesId = authoritiesId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
}
