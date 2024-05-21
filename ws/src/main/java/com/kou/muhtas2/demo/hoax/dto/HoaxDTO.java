package com.kou.muhtas2.demo.hoax.dto;

import com.kou.muhtas2.demo.file.FileAttachment;
import com.kou.muhtas2.demo.file.dto.FileAttachmentDTO;
import com.kou.muhtas2.demo.hoax.Hoax;
import com.kou.muhtas2.demo.user.dto.UserDTO;
import lombok.Data;

@Data
public class HoaxDTO {

    int id;
    String content;
    long timestamp;
    FileAttachmentDTO fileAttachment;
    public HoaxDTO(Hoax hoax){
        setId(hoax.getId());
        setContent(hoax.getContent());
        setTimestamp(hoax.getTimestamp().getTime());
        if (hoax.getFileAttachment() != null){
            this.fileAttachment=new FileAttachmentDTO(hoax.getFileAttachment());
        }
    }

}
