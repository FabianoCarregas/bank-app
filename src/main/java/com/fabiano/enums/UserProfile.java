package com.fabiano.enums;

public enum UserProfile {
	
	ADMIN(1, "ROLE_ADMIN"),
	CLIENT(2, "ROLE_CLIENT");
	
	private Integer code;
	private String description;
	
	private UserProfile(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static UserProfile toEnum(Integer code) {
		
			if (code == null) {
				return null;
			}
			
			for (UserProfile value : UserProfile.values()) {
				if (code.equals(value.getCode())) {
					return value;
				}
			
		}
		
		throw new IllegalArgumentException("Invalid id" + code);
	}
	
}