package com.example.school.repository;

import com.example.school.entity.StudentAttendancesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAttendancesRepository extends JpaRepository<StudentAttendancesEntity,Integer> {


}
