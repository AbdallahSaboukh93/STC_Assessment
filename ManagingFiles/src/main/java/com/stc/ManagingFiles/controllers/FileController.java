package com.stc.ManagingFiles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stc.ManagingFiles.services.FileService;

@RestController
@RequestMapping("/api/files")
public class FileController {

	@Autowired
	private FileService fileService ; 

    @GetMapping("/{id}")
    public ResponseEntity<?> getFileById(@PathVariable Long id, @RequestParam String userEmail) {
        return ResponseEntity.ok(fileService.findByFileIdAndUserEmail(id, userEmail));
    }
    
    
    @GetMapping("/{fileId}/download")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long fileId, @RequestParam String userEmail) {
        return ResponseEntity.ok(fileService.downloadFile(fileId, userEmail));

    }
}
