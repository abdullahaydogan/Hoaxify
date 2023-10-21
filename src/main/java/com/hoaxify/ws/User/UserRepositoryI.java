package com.hoaxify.ws.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryI extends JpaRepository<User,Long> {
}
