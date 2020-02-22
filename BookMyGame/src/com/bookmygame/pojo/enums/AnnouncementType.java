package com.bookmygame.pojo.enums;

public enum AnnouncementType {

	ADMIN("admin"), PLAYER("player"), OWNER("owner");

	private String name;

	AnnouncementType(String name) {

		this.name = name;
	}

	public String getTypeName() {
		return name;
	}
}
