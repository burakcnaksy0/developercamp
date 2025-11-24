package com.burakcanaksoy.developercamp.dataAccess.abstracts;

import com.burakcanaksoy.developercamp.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);

}
