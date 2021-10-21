package com.example.school.repository;

import com.example.school.entity.StaffSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffSubjectRepository extends JpaRepository<StaffSubject,Integer> {

}
