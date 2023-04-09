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
public class ItemDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5628111104639889969L;

	private Long id;

	private String type;

	private String name;

	private Long parentItemId;

	private byte[] binary;

	private PermissionGroupDto permissionGroup;
}
