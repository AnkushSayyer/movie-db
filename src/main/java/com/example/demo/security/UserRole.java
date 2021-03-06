package com.example.demo.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum UserRole {
	USER(Sets.newHashSet(UserPermission.WATCHLIST_READ, UserPermission.WATCHLIST_WRITE)),
	ADMIN(Sets.newHashSet(UserPermission.DOMAIN_WRITE));

	private final Set<UserPermission> permissions;

	UserRole(Set<UserPermission> permissions){
		this.permissions = permissions;
	}

	public Set<UserPermission> getPermissions() {
		return permissions;
	}

	public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
		Set<SimpleGrantedAuthority> grantedAuthorities = getPermissions().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
		return grantedAuthorities;
	}
}
