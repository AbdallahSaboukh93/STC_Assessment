package com.stc.ManagingFiles.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.stc.ManagingFiles.entities.File;

public interface FileRepository extends CrudRepository<File, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM file f " + "JOIN item i ON f.item_id = i.id "
			+ "JOIN permission p ON p.group_id = i.permission_group_id "
			+ "WHERE f.id = :fileId AND p.user_email = :userEmail")
	File findByFileIdAndUserEmail(Long fileId, String userEmail);
}
