package com.stc.ManagingFiles.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stc.ManagingFiles.dto.ItemDto;
import com.stc.ManagingFiles.dto.PermissionDto;
import com.stc.ManagingFiles.entities.Item;
import com.stc.ManagingFiles.entities.Permission;
import com.stc.ManagingFiles.entities.PermissionGroup;
import com.stc.ManagingFiles.repositories.ItemRepository;
import com.stc.ManagingFiles.repositories.PermissionGroupRepository;
import com.stc.ManagingFiles.repositories.PermissionRepository;
import com.stc.ManagingFiles.services.ItemService;

@Service
public class DefaultItemService implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private PermissionGroupRepository permissionGroupRepository;

	@Transactional
	public Item createItem(ItemDto itemDto) {
		PermissionGroup permissionGroup = createPermissions(itemDto);
		return createItem(itemDto, permissionGroup);
	}

	private Item createItem(ItemDto itemDto, PermissionGroup permissionGroup) {
		Item item = new Item();
		item.setName(itemDto.getName());
		item.setPermissionGroup(permissionGroup);
		return itemRepository.save(item);
	}

	private PermissionGroup createPermissions(ItemDto itemDto) {
		PermissionGroup permissionGroup = new PermissionGroup();

		if (itemDto.getPermissionGroup().getPermissions() != null
				&& !itemDto.getPermissionGroup().getPermissions().isEmpty()) {
			for (PermissionDto permissionDto : itemDto.getPermissionGroup().getPermissions()) {
				Permission permission = new Permission();
				permission.setUserEmail(permissionDto.getUserEmail());
				permission.setPermissionLevel(permissionDto.getPermissionLevel());
				permission.setPermissionGroup(permissionGroup);
				permissionGroup.getPermissions().add(permission);
			}
		}

		permissionGroup.setGroupName(itemDto.getPermissionGroup().getGroupName());
		return permissionGroupRepository.save(permissionGroup);
	}
}