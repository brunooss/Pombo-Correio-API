package com.bossindustries.pombocorreioserver.repository;

import com.bossindustries.pombocorreioserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //User findByName(String name);
}
