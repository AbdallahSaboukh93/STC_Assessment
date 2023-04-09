package com.stc.ManagingFiles.services;

import com.stc.ManagingFiles.entities.File;

public interface FileService {

	File findByFileIdAndUserEmail(Long id, String userEmail);

	byte[] downloadFile(Long fileId, String userEmail);

}
