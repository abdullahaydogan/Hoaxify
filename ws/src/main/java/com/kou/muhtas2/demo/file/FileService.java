package com.kou.muhtas2.demo.file;

import com.kou.muhtas2.demo.configuration.MuhTas2Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@EnableScheduling
public class FileService {

    @Autowired
    MuhTas2Properties muhTas2Properties;

    @Autowired
    FileAttahmentRepository fileAttahmentRepository;


    public String saveBase64StringAsFile(String image) {
        String fileName = UUID.randomUUID().toString();
        Path path = Paths.get(muhTas2Properties.getStorage().getRoot(), muhTas2Properties.getStorage().getProfile(), fileName);
        File file = new File(fileName);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            byte[] base64decoded = Base64.getDecoder().decode(image.split(",")[1]);
            outputStream.write(base64decoded);
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }


    public FileAttachment saveHoaxAttachment(MultipartFile multipartFile) {
        String fileName = UUID.randomUUID().toString();
        File file = new File(fileName);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(multipartFile.getBytes());
            outputStream.close();

        } catch (IOException e) {
            throw new RuntimeException("Failed to save attachment");
        }
        FileAttachment attachment = new FileAttachment();
        attachment.setName(fileName);
        attachment.setDate(new Date());
    return fileAttahmentRepository.save(attachment);
    }




}
