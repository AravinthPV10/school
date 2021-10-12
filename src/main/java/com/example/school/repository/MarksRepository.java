package com.example.school.repository;

import com.example.school.entity.MarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MarksRepository extends JpaRepository<MarksEntity,Integer> {
    @Query(value = "select distinct student.stud_name from student inner join student_std where student.stud_id = (select distinct student_std.student_id from student_std inner join marks where student_std.id=:id);",nativeQuery = true)
    String getstuId(int id);

    @Query(value = "select distinct subject.subj_name from subject inner join subject_std where subject.subj_id = (select distinct subject_std.subject_id from subject_std inner join marks where subject_std.id=:id);",nativeQuery = true)
    String getsubjname(int id);

    @Query(value = "select (count(stud_id)/(select count(stud_id) from student_attendances where stud_id = :id))*100 as percent from student_attendances where stud_id = :id and status = \"P\";",nativeQuery = true)
    double getAttendance(int id);
}
