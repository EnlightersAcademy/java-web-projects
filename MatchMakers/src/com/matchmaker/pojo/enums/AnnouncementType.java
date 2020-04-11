package com.matchmaker.pojo.enums;

public enum AnnouncementType {

	HALLS("halls"), BOUTIQUES("boutiques"), CATERING("catering");

	private String name;

	AnnouncementType(String name) {

		this.name = name;
	}

	public String getTypeName() {
		return name;
	}
}
