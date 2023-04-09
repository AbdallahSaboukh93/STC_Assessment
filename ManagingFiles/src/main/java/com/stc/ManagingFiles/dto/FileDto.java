package com.stc.ManagingFiles.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDto  implements Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 6290900469453726746L;

	private Long id;
    
    private byte[] binary;

    private ItemDto item;
}
