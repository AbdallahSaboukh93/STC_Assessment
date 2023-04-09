package com.stc.ManagingFiles.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionGroupDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2305046055227397742L;

	private Long id;

	private String groupName;

	private List<ItemDto> items;

	private List<PermissionDto> permissions;

}
