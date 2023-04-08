package com.stc.ManagingFiles.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class PermissionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2421461062648700347L;

	private Long id;

	private String userEmail;

	private String permissionLevel;

	private PermissionGroupDto permissionGroup;

}