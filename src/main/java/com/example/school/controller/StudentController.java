package com.example.school.controller;


import com.example.school.dto.ResultDTO;
import com.example.school.dto.StudentDTO;
import com.example.school.dto.StudentStandardDTO;
import com.example.school.service.impl.StudentServiceImpl;
import com.example.school.service.impl.StudentStdServiceImpl;
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

    @PostMapping("/add-student")
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

    @PostMapping("/add-standard")
    public ResponseEntity<StudentStandardDTO> addStudentStandard(@RequestBody StudentStandardDTO studentStandardDTO){

        StudentStandardDTO studentStandardDTO1 = new StudentStandardDTO();
        studentStandardDTO1 = studentStdService.addStudStd(studentStandardDTO);
        return new ResponseEntity<>(studentStandardDTO1, HttpStatus.OK);
    }

    @PutMapping("/update-standard")
    public ResponseEntity<StudentStandardDTO> updateStudentStandard(@RequestBody StudentStandardDTO studentStandardDTO){

        StudentStandardDTO studentStandardDTO1 = new StudentStandardDTO();
        studentStandardDTO1 = studentStdService.updateStudStd(studentStandardDTO);
        return new ResponseEntity<>(studentStandardDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/standard")
    public ResponseEntity<String> deleteStudentStandard(@RequestBody StudentStandardDTO studentStandardDTO){

        String message = studentStdService.deleteStudStd(studentStandardDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/all-standard")
    public ResponseEntity<String> deleteAllStudentStandard(){

        String message = studentStdService.deleteAllStudStd();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/standard")
    public ResponseEntity<StudentStandardDTO> showStudentStandard(@RequestBody StudentStandardDTO studentStandardDTO){

        StudentStandardDTO studentStandardDTO1 = studentStdService.showStudStd(studentStandardDTO);
        return new ResponseEntity<>(studentStandardDTO1,HttpStatus.OK);
    }

    @GetMapping("/all-standard")
    public ResponseEntity<List<StudentStandardDTO>> showAllStudentStandard(){

        List<StudentStandardDTO> studentStandardDTOList = studentStdService.showAllStudStd();
        return new ResponseEntity<>(studentStandardDTOList,HttpStatus.OK);
    }

    @GetMapping("/results")
    public ResponseEntity<List<ResultDTO>> showResults(){
        List<ResultDTO> resultDTOList = studentStdService.getResults();
        return new ResponseEntity<>(resultDTOList,HttpStatus.OK);
    }

}