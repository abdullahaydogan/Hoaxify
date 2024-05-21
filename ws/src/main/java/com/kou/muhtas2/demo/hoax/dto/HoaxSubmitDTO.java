package com.kou.muhtas2.demo.hoax.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HoaxSubmitDTO {

    @Size(min = 1,max = 1000)
    String content;
    long attachmentId;
}
