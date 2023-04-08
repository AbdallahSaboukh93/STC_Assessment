package com.stc.ManagingFiles.services;

import com.stc.ManagingFiles.dto.ItemDto;
import com.stc.ManagingFiles.entities.Item;

public interface ItemService {

	Item createItem(ItemDto itemDto);

}
