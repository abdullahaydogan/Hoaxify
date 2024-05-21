package com.kou.muhtas2.demo.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.Map;

@RestController
public class FileController {

    @Autowired
    FileService fileService;


    @PostMapping("/api/v1/hoax-attachments")
    FileAttachment saveHoaxAttachment(@RequestParam(name = "file") MultipartFile file){
      return fileService.saveHoaxAttachment(file);

    }
}
