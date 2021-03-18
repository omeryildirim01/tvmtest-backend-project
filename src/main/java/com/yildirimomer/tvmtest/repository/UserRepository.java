package com.yildirimomer.tvmtest.repository;

import com.yildirimomer.tvmtest.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select s from User s where name like %?1%")
    List<User> findByName(String name);
}