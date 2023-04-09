package com.stc.ManagingFiles.services;

import com.stc.ManagingFiles.dto.ItemDto;
import com.stc.ManagingFiles.entities.Item;

public interface ItemService {

	Long createItem(ItemDto itemDto);

}
