package com.example.school.repository;

import com.example.school.dto.AttendancePercentageDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendancePercentageRepository extends JpaRepository<AttendancePercentageDTO,Integer> {
    @Query(value = "select roll_number, (count(roll_number)/(select count(roll_number) from student_attendances where roll_number = :id))*100 as percent from student_attendances where roll_number = :id and status = \"P\";",nativeQuery = true)
    AttendancePercentageDTO getStudentAttendancePercentage(int id);

    @Query(value = "select staff_roll_number, (count(staff_roll_number)/(select count(staff_roll_number) from staff_attendance where staff_roll_number = :id))*100 as percent from staff_attendance where staff_roll_number = :id and status = \"P\";",nativeQuery = true)
    AttendancePercentageDTO getStaffAttendancePercentage(int id);
}
