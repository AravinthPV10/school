package com.example.school.repository;

import com.example.school.entity.StudentStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentStdRepository extends JpaRepository<StudentStandard,Integer> {

}
