package com.kou.muhtas2.demo.hoax;

import com.kou.muhtas2.demo.file.FileAttachment;
import com.kou.muhtas2.demo.file.FileAttahmentRepository;
import com.kou.muhtas2.demo.hoax.dto.HoaxDTO;
import com.kou.muhtas2.demo.hoax.dto.HoaxSubmitDTO;
import com.kou.muhtas2.demo.user.User;
import com.kou.muhtas2.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class HoaxService {
    @Autowired
    HoaxRepository hoaxRepository;
    @Autowired
    UserService userService;
    @Autowired
    FileAttahmentRepository fileAttahmentRepository;


    public void save(HoaxSubmitDTO hoaxSubmitDTO ) {
        Hoax hoax =new Hoax();
        hoax.setContent(hoaxSubmitDTO.getContent());
        hoax.setTimestamp(new Date());
        hoax.setUser(hoax.getUser());
        hoaxRepository.save(hoax);
        Optional<FileAttachment> optionalFileAttachment = fileAttahmentRepository.findById(hoaxSubmitDTO.getAttachmentId());
        if (optionalFileAttachment.isPresent()){
            FileAttachment fileAttachment=optionalFileAttachment.get();
            fileAttachment.setHoax(hoax);
            fileAttahmentRepository.save(fileAttachment);
        }
    }

    public Page<Hoax> getHoaxes(Pageable pageable) {
      return   hoaxRepository.findAll(pageable);
    }

    public Page<Hoax> getHoaxesOfUser(String username, Pageable pageable) {
        User inDB =userService.getByUsername(username);
        return hoaxRepository.findByUser(inDB,pageable);
    }


    public void deleteHoax(int id) {
        hoaxRepository.deleteById(id);
    }
}
