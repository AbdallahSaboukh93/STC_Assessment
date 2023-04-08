package com.stc.ManagingFiles.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import lombok.Data;

@Entity
@Table(name = "permission_groups")
@Data
public class PermissionGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7809260785118877862L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String groupName;

	@OneToMany(mappedBy = "permissionGroup")
	private List<Item> items;
	
	@OneToMany(mappedBy = "permissionGroup")
	private List<Permission> Permissions;


	// getters and setters
}
