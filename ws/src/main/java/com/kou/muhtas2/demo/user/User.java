package com.kou.muhtas2.demo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.kou.muhtas2.demo.hoax.Hoax;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;


@Data
@Entity
//@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NotBlank
    String username;

    @NotBlank
    @JsonIgnore
    String password;
    @NotBlank
    @Email
    // @UniqueEmail
    String email;
    @JsonIgnore
    String activationToken;
    @JsonIgnore
    boolean active = false;
    @Lob
    String image;
    @OneToMany(mappedBy = "user")
    List<Hoax> hoaxes;




}
