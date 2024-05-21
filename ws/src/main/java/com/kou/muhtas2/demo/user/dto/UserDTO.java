package com.kou.muhtas2.demo.user.dto;

import com.kou.muhtas2.demo.user.User;
import lombok.Data;


@Data
public class UserDTO extends User {
    int id;
    String username;
    String email;
    String image;


    public UserDTO(User user) {

        setId(user.getId());
        setUsername(user.getUsername());
        setEmail(user.getEmail());
        setImage(user.getImage());

    }

}
