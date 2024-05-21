package com.kou.muhtas2.demo.user;

import com.kou.muhtas2.demo.email.EmailService;
import com.kou.muhtas2.demo.file.FileService;
import com.kou.muhtas2.demo.user.dto.UserUpdate;
import com.kou.muhtas2.demo.user.exceptions.ActivationNotificationException;
import com.kou.muhtas2.demo.user.exceptions.InvalidTokenException;
import com.kou.muhtas2.demo.user.exceptions.NotUniqueEmailException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    EmailService emailService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    FileService fileService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveUser(User user) {
        try {
            user.setActivationToken(UUID.randomUUID().toString());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.saveAndFlush(user);
            emailService.sendEmail(user.getEmail(), user.getActivationToken());
        } catch (DataIntegrityViolationException ex) {
            throw new NotUniqueEmailException();
        } catch (MailException exception) {
            throw new ActivationNotificationException();
        }

    }

    public void activateUser(String token) {
        User inDB = userRepository.findByActivationToken(token);
        if (inDB == null) {
            throw new InvalidTokenException();
        }
        inDB.setActive(true);
        inDB.setActivationToken(null);
        userRepository.save(inDB);
    }

    public Page<User> getUsers(Pageable pageable, User loggedInUser) {
        if (loggedInUser == null) {
            return userRepository.findAll(pageable);
        }
        return userRepository.findByIdNot(loggedInUser.getId(), pageable);

    }

    public User getUser(int id) {
        return userRepository.getReferenceById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUser(int id, @Valid UserUpdate userUpdate) {
        User inDB = getUser(id);
        inDB.setUsername(userUpdate.username());
        if (userUpdate.image() != null) {
            String fileName = fileService.saveBase64StringAsFile(userUpdate.image());
            inDB.setImage(fileName);
        }
        return userRepository.save(inDB);
    }
    
    public User findById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }


    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


    public User getByUsername(String username){
        User inDB = userRepository.getByUsername(username);
        if (inDB==null){
            throw new RuntimeException();
        }
        return inDB;
    }


}
