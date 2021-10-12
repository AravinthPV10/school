package com.example.school.repository;

import com.example.school.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SubjectRepository extends JpaRepository<SubjectEntity,Integer> {

}
