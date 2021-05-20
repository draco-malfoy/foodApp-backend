package com.mt.FoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.FoodApp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
