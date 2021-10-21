package com.example.school.repository;

import com.example.school.entity.SubjectStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectStdRepository extends JpaRepository<SubjectStandard,Integer> {

}
