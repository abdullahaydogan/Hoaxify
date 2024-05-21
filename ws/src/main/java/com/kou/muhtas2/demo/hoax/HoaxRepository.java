package com.kou.muhtas2.demo.hoax;

import com.kou.muhtas2.demo.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaxRepository extends JpaRepository <Hoax,Integer> {
    Page<Hoax> findByUser(User user, Pageable pageable);
}
