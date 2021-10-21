package com.example.school.repository;

import com.example.school.entity.StudentAttendancesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAttendancesRepository extends JpaRepository<StudentAttendancesEntity,Integer> {


}
