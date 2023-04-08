package com.stc.ManagingFiles.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5628111104639889969L;

	private Long id;

	private String type;

	private String name;
	
	private Long parentItemId;

	private PermissionGroupDto permissionGroup;
}
