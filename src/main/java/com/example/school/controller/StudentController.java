package com.example.school.controller;


import com.example.school.dto.StudentDTO;
import com.example.school.dto.StudentStdDTO;
import com.example.school.dto.SubjectStdDTO;
import com.example.school.service.impl.StudentServiceImpl;
import com.example.school.service.impl.StudentStdServiceImpl;
import com.example.school.service.impl.SubjectStdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    //Student//

    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("/new-student")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO){

        StudentDTO studentDTO1 = studentService.addStudent(studentDTO);
        return new ResponseEntity<>(studentDTO1, HttpStatus.OK);
    }

    @PutMapping("/update-student")
    public  ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO){

        StudentDTO studentDTO1 = studentService.updateStudent(studentDTO);
        return new ResponseEntity<>(studentDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/student")
    public ResponseEntity<String> deleteStudent(@RequestBody StudentDTO studentDTO){

        String message = studentService.deleteStudent(studentDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/all-students")
    public ResponseEntity<String> deleteAllStudents(){

        String message = studentService.deleteAllStudents();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/single-student")
    public ResponseEntity<StudentDTO> showStudent(@RequestBody StudentDTO studentDTO){

        StudentDTO studentDTO1 = studentService.showStudent(studentDTO);
        return new ResponseEntity<>(studentDTO1,HttpStatus.OK);
    }

    @GetMapping("/all-students")
    public ResponseEntity<List<StudentDTO>> showAllStudent(){

        List<StudentDTO> studentDTOS = studentService.showAllStudents();
        return new ResponseEntity<>(studentDTOS,HttpStatus.OK);
    }


    //student standard//

    @Autowired
    StudentStdServiceImpl studentStdService;

    @PostMapping("/new-standard")
    public ResponseEntity<StudentStdDTO> addStudStd(@RequestBody StudentStdDTO studentStdDTO){

        StudentStdDTO studentStdDTO1 = new StudentStdDTO();
        studentStdDTO1 = studentStdService.addStudStd(studentStdDTO);
        return new ResponseEntity<>(studentStdDTO1, HttpStatus.OK);
    }

    @PutMapping("/update-standard")
    public ResponseEntity<StudentStdDTO> updateStudStd(@RequestBody StudentStdDTO studentStdDTO){

        StudentStdDTO studentStdDTO1 = new StudentStdDTO();
        studentStdDTO1 = studentStdService.updateStudStd(studentStdDTO);
        return new ResponseEntity<>(studentStdDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/standard")
    public ResponseEntity<String> deleteStudStd(@RequestBody StudentStdDTO studentStdDTO){

        String message = studentStdService.deleteStudStd(studentStdDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/all-standard")
    public ResponseEntity<String> deleteAllStudStd(){

        String message = studentStdService.deleteAllStudStd();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/standard")
    public ResponseEntity<StudentStdDTO> showStudStd(@RequestBody StudentStdDTO studentStdDTO){

        StudentStdDTO studentStdDTO1 = studentStdService.showStudStd(studentStdDTO);
        return new ResponseEntity<>(studentStdDTO1,HttpStatus.OK);
    }

    @GetMapping("/all-standard")
    public ResponseEntity<List<StudentStdDTO>> showAllStudStd(){

        List<StudentStdDTO> studentStdDTOList = studentStdService.showAllStudStd();
        return new ResponseEntity<>(studentStdDTOList,HttpStatus.OK);
    }

}