package com.stc.ManagingFiles.services.impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stc.ManagingFiles.dto.ItemDto;
import com.stc.ManagingFiles.dto.PermissionDto;
import com.stc.ManagingFiles.entities.File;
import com.stc.ManagingFiles.entities.Item;
import com.stc.ManagingFiles.entities.Permission;
import com.stc.ManagingFiles.entities.PermissionGroup;
import com.stc.ManagingFiles.enums.ItemType;
import com.stc.ManagingFiles.repositories.FileRepository;
import com.stc.ManagingFiles.repositories.ItemRepository;
import com.stc.ManagingFiles.repositories.PermissionGroupRepository;
import com.stc.ManagingFiles.services.ItemService;

@Service
public class DefaultItemService implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private PermissionGroupRepository permissionGroupRepository;

	@Autowired
	private FileRepository fileRepository;

	ObjectMapper mapper = new ObjectMapper();

	@Transactional
	public Long createItem(ItemDto itemDto) {
		PermissionGroup permissionGroup = createPermissions(itemDto);
		return createItem(itemDto, permissionGroup).getId();
	}

	private Item createItem(ItemDto itemDto, PermissionGroup permissionGroup) {
		Item item = new Item();
		item.setName(itemDto.getName());
		item.setType(itemDto.getType());
		item.setPermissionGroup(permissionGroup);
		if (itemDto.getParentItemId() != null) {
			item.setParentItem(itemRepository.findById(itemDto.getParentItemId()).get());
		}
		createFile(itemDto, item);
		return itemRepository.save(item);
	}

	private void createFile(ItemDto itemDto, Item item) {
		if (itemDto.getType() == ItemType.FILE.getItemType()) {
			File file = new File();
			file.setItem(item);
			file.setBinaryq(itemDto.getBinary().toString());
			fileRepository.save(file);
		}
	}

	private PermissionGroup createPermissions(ItemDto itemDto) {
		PermissionGroup permissionGroup = new PermissionGroup();

		if (itemDto.getPermissionGroup().getPermissions() != null
				&& !itemDto.getPermissionGroup().getPermissions().isEmpty()) {
			permissionGroup.setPermissions(new ArrayList<>());
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