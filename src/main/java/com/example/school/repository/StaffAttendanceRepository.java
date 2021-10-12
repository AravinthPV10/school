package com.example.school.repository;

import com.example.school.entity.StaffAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffAttendanceRepository extends JpaRepository<StaffAttendanceEntity,Integer> {

}
