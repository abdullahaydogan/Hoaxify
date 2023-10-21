package com.hoaxify.ws.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepositoryI userRepositoryI;

    public void save(User user ){
        userRepositoryI.save(user);
    }

}
