package com.example.school.service.impl;

import com.example.school.dto.StudentDTO;
import com.example.school.entity.StudentEntity;
import com.example.school.mapper.StudentMapper;
import com.example.school.repository.StudentRepository;
import com.example.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        StudentEntity student = new StudentEntity();
        student= StudentMapper.INSTANCE.toStudentEntity(studentDTO);
        student= studentRepository.save(student);
        return StudentMapper.INSTANCE.toStudentDto(student);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        StudentEntity student = new StudentEntity();
        student= studentRepository.findById(studentDTO.getStudId()).map(res->{
            if(studentDTO.getStudName()!=null)
                res.setStudName(studentDTO.getStudName());
            if(studentDTO.getStudAge()!=0)
                res.setStudAge(studentDTO.getStudAge());
            if(studentDTO.getStudPhone()!=0)
                res.setStudPhone(studentDTO.getStudPhone());
            return res;
        }).get();
        return StudentMapper.INSTANCE.toStudentDto(student);
    }

    @Override
    public String deleteStudent(StudentDTO studentDTO) {
        studentRepository.deleteById(studentDTO.getStudId());
        return "Deleted Record: "+studentDTO.getStudId();
    }

    @Override
    public String deleteAllStudents() {
        studentRepository.deleteAll();
        return "Deleted All Records.";
    }

    @Override
    public StudentDTO showStudent(StudentDTO studentDTO) {
        StudentEntity student = new StudentEntity();
        student = studentRepository.findById(studentDTO.getStudId()).get();
        return StudentMapper.INSTANCE.toStudentDto(student);
    }

    @Override
    public List<StudentDTO> showAllStudents() {
        return  Optional.of(studentRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(StudentMapper.INSTANCE::toStudentDto)
                .collect(Collectors.toList());
    }
}
