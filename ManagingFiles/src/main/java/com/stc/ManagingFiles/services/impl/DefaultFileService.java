package com.stc.ManagingFiles.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.stereotype.Service;

import com.stc.ManagingFiles.entities.File;
import com.stc.ManagingFiles.enums.PermissionLevel;
import com.stc.ManagingFiles.repositories.FileRepository;
import com.stc.ManagingFiles.services.FileService;

@Service
public class DefaultFileService implements FileService {

	@Autowired
	private FileRepository fileRepository;

	@Override
	public File findByFileIdAndUserEmail(Long id, String userEmail) {

		File file = fileRepository.findByFileIdAndUserEmail(id, userEmail);
		if (file.getItem() != null & file.getItem().getPermissionGroup().getPermissions().stream()
				.anyMatch(p -> p.getPermissionLevel() == PermissionLevel.VIEW.name())) {
			return file;
		}

		throw new PermissionDeniedDataAccessException("You do not have permission to access this file", null);

	}

	@Override
	public byte[] downloadFile(Long fileId, String userEmail) {
		File file = fileRepository.findByFileIdAndUserEmail(fileId, userEmail);
		if (file.getItem() != null & file.getItem().getPermissionGroup().getPermissions().stream()
				.anyMatch(p -> p.getPermissionLevel() == PermissionLevel.VIEW.name())) {
			return file.getBinaryq().getBytes();
		}

		throw new PermissionDeniedDataAccessException("You do not have permission to access this file", null);

	}

}
