package com.example.school.repository;

import com.example.school.entity.StaffAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffAttendanceRepository extends JpaRepository<StaffAttendanceEntity,Integer> {

}
