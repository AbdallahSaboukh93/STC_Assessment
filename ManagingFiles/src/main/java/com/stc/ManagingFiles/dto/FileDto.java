package com.stc.ManagingFiles.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class FileDto  implements Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 6290900469453726746L;

	private Long id;
    
    private byte[] binary;

    private ItemDto item;
}
