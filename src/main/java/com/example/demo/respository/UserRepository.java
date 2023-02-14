package com.example.demo.respository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Data Access Layer
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
