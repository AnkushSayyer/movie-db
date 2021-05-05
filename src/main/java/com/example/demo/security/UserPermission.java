package com.example.demo.security;

public enum UserPermission {
	DOMAIN_WRITE("domain:write"),
	WATCHLIST_READ("watchlist:read"),
	WATCHLIST_WRITE("watchlist:write");

	private final String permission;

	UserPermission(String permission){
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
}
