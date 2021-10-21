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
        student= studentRepository.findById(studentDTO.getStudent_id()).map(res->{
            if(studentDTO.getStudent_name()!=null)
                res.setStudent_name(studentDTO.getStudent_name());
            if(studentDTO.getStudent_age()!=0)
                res.setStudent_age(studentDTO.getStudent_age());
            if(studentDTO.getStudent_phone()!=0)
                res.setStudent_phone(studentDTO.getStudent_phone());
            return res;
        }).get();
        return StudentMapper.INSTANCE.toStudentDto(student);
    }

    @Override
    public String deleteStudent(StudentDTO studentDTO) {
        studentRepository.deleteById(studentDTO.getStudent_id());
        return "Deleted Record: "+studentDTO.getStudent_id();
    }

    @Override
    public String deleteAllStudents() {
        studentRepository.deleteAll();
        return "Deleted All Records.";
    }

    @Override
    public StudentDTO showStudent(StudentDTO studentDTO) {
        StudentEntity student = new StudentEntity();
        student = studentRepository.findById(studentDTO.getStudent_id()).get();
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
