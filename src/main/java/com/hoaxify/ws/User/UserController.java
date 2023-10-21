package com.hoaxify.ws.User;

import com.hoaxify.ws.Error.ApiError;
import com.hoaxify.ws.Shared.GenericMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/v1/users")
    ResponseEntity<?> createUser(@RequestBody User user){
        if (user.getName()==null||user.getName().isEmpty() ){
            ApiError apiError=new ApiError();
            apiError.setPath("/api/v1/users");
            apiError.setMessage("Validation Error");
            apiError.setStatus(400);
            Map<String,String> validationErrors=new HashMap<>();
            validationErrors.put("username","Username can not be null");
            apiError.setValidationErrors(validationErrors);
            return ResponseEntity.badRequest().body(apiError);
        }

        userService.save(user);

        return ResponseEntity.ok(new GenericMessage("user is created"));
    }



}
