package com.kou.muhtas2.demo.user;

import com.kou.muhtas2.demo.auth.token.TokenService;
import com.kou.muhtas2.demo.hoax.HoaxService;
import com.kou.muhtas2.demo.shared.GenericMessage;
import com.kou.muhtas2.demo.shared.Messages;
import com.kou.muhtas2.demo.user.dto.UserCreate;
import com.kou.muhtas2.demo.user.dto.UserDTO;
import com.kou.muhtas2.demo.user.dto.UserUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;
    @Autowired
    HoaxService hoaxService;

    @PostMapping("/create")
    GenericMessage createUser(@Valid @RequestBody UserCreate userCreate) {
        userService.saveUser(userCreate.toUser());
        String message = Messages.getMessageForLocale("Muhtas2.create.user.succes.message", LocaleContextHolder.getLocale());
        return new GenericMessage(message);
    }

    @PatchMapping("/{token}/active")
    GenericMessage activateUser(@PathVariable String token) {
        userService.activateUser(token);
        String message = Messages.getMessageForLocale("Muhtas2.activate.user.succes.message", LocaleContextHolder.getLocale());
        return new GenericMessage(message);
    }

    @GetMapping("/list")
    public Page<UserDTO> getUsers(Pageable pageable, @RequestHeader(name = "Authorization", required = false) String authorizationHeader) {
        var loggedInUser = tokenService.verifyToken(authorizationHeader);
        return userService.getUsers(pageable, loggedInUser).map(UserDTO::new);
    }

    @GetMapping("/{id}")
    UserDTO getUserById(@PathVariable int id) {
        return new UserDTO(userService.getUser(id));
    }

    @PutMapping("/{id}")
    UserDTO updateUser(@PathVariable int id, @RequestBody UserUpdate userUpdate) {
        return new UserDTO(userService.updateUser(id, userUpdate));
    }

    @DeleteMapping("/{id}")
    GenericMessage deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new GenericMessage("User is Deleted.");
    }




}
