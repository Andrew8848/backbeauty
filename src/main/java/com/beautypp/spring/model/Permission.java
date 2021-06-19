package com.beautypp.spring.model;

public enum Permission {
	PRODUCT_READ("product:read"),
	PRODUCT_WRITE("product:write");

	private final String permission;
	
	Permission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}

}
