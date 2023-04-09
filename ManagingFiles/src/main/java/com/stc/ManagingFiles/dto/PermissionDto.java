package com.stc.ManagingFiles.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
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