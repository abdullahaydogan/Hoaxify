package com.kou.muhtas2.demo.hoax;

import com.kou.muhtas2.demo.file.FileAttachment;
import com.kou.muhtas2.demo.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Hoax {

    @Id
    @GeneratedValue
    int id;
    @Size(min = 1,max = 1000)
    String content;
    @Temporal(TemporalType.TIMESTAMP)
    Date timestamp;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;
    @OneToOne(mappedBy = "hoax")
    FileAttachment fileAttachment;





}
