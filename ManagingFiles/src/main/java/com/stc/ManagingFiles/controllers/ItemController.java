package com.stc.ManagingFiles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.ManagingFiles.dto.ItemDto;
import com.stc.ManagingFiles.entities.Item;
import com.stc.ManagingFiles.services.ItemService;

@RestController
@RequestMapping("/api")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping("/item")
	public ResponseEntity<Item> createItem(@RequestBody ItemDto itemDto) {
		return ResponseEntity.ok(itemService.createItem(itemDto));
	}
}