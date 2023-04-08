package com.stc.ManagingFiles.repositories;

import org.springframework.data.repository.CrudRepository;

import com.stc.ManagingFiles.entities.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
