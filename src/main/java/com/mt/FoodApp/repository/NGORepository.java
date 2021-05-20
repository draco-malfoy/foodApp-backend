package com.mt.FoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.FoodApp.model.NGO;

@Repository
public interface NGORepository extends JpaRepository<NGO, Long> {

}
