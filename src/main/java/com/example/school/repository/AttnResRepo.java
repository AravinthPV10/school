package com.example.school.repository;

import com.example.school.dto.AttnResDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttnResRepo extends JpaRepository<AttnResDTO,Integer> {
    @Query(value = "select stud_id, (count(stud_id)/(select count(stud_id) from student_attendances where stud_id = :id))*100 as percent from student_attendances where stud_id = :id and status = \"P\";",nativeQuery = true)
    AttnResDTO getAttendance(int id);

    @Query(value = "select staff_id, (count(staff_id)/(select count(staff_id) from staff_attendance where staff_id = :id))*100 as percent from staff_attendance where staff_id = :id and status = \"P\";",nativeQuery = true)
    AttnResDTO getStaffAttendance(int id);
}
