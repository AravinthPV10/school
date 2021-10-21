package com.example.school.repository;

import com.example.school.entity.MarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends JpaRepository<MarksEntity,Integer> {
    @Query(value = "select distinct student.student_name from student inner join student_std where student.student_id = (select distinct student_std.student_id from student_std inner join marks where student_std.roll_number=:id);",nativeQuery = true)
    String getStudentName(@Param("id") int id);

    @Query(value = "select distinct subject.subject_name from subject inner join subject_std where subject.subject_id = (select distinct subject_std.subject_id from subject_std inner join marks where subject_std.id=:id);",nativeQuery = true)
    String getSubjectName(@Param("id")int id);

    @Query(value = "select (count(roll_number)/(select count(roll_number) from student_attendances where roll_number = :id))*100 as percent from student_attendances where roll_number = :id and status = \"P\";",nativeQuery = true)
    double getAttendancePercentage(@Param("id")int id);


    @Query(value = "select count(status) from student_attendances where roll_number =:id and status = \"P\";",nativeQuery = true)
    int getDaysPresent(@Param("id")int id);

    @Query(value = "select count(status) from student_attendances where roll_number =:id and status = \"AB\";",nativeQuery = true)
    int getDaysAbsent(@Param("id")int id);

}
