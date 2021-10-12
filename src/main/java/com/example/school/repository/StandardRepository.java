package com.example.school.repository;

import com.example.school.entity.StandardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StandardRepository extends JpaRepository<StandardEntity,Integer> {

}
