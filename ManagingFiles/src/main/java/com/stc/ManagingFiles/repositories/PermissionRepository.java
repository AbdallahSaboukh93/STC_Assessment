package com.stc.ManagingFiles.repositories;

import org.springframework.data.repository.CrudRepository;

import com.stc.ManagingFiles.entities.Permission;

public interface PermissionRepository extends CrudRepository<Permission, Long> {

}
