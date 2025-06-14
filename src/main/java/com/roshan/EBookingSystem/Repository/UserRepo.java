package com.roshan.EBookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roshan.EBookingSystem.Entity.User;

import jakarta.transaction.Transactional;


public interface UserRepo extends JpaRepository<User, Integer>{
    
    User findByUserName(String userName);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.userName = :userName AND u.password = :password")
    Integer deleteByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
