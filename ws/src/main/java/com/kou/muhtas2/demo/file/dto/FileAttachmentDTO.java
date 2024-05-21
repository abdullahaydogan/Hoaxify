package com.kou.muhtas2.demo.file.dto;

import com.kou.muhtas2.demo.file.FileAttachment;
import lombok.Data;

@Data
public class FileAttachmentDTO {
    String name;

    public FileAttachmentDTO(FileAttachment fileAttachment){
        this.setName(fileAttachment.getName());
    }

}
