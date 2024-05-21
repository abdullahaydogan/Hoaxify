package com.kou.muhtas2.demo.file;

import com.kou.muhtas2.demo.hoax.Hoax;
import jakarta.persistence.*;
import jdk.jfr.Timespan;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class FileAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @Temporal(TemporalType.DATE)
    Date date;
    @OneToOne
    Hoax hoax;


}
