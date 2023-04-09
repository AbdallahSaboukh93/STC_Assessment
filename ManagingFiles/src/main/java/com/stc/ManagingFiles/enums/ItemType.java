package com.stc.ManagingFiles.enums;

public enum ItemType {
	SPACE("SPACE"),
	FOLDER("FOLDER"),
	FILE("FILE");
   // SPACE,
   // FOLDER,
   // FILE
	private String itemType;

	ItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemType() {
		return itemType;
	}

}
