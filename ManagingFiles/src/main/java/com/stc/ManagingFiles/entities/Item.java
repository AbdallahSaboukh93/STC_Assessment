package com.stc.ManagingFiles.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.stc.ManagingFiles.enums.ItemType;

import lombok.Data;

@Entity
@Table(name = "item")
@Data
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4102652629269208620L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String type;

	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_item_id")
	private Item parentItem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permission_group_id")
	private PermissionGroup permissionGroup;

}
