package com.example.school.service.impl;

import com.example.school.dto.ResultDTO;
import com.example.school.dto.ResultMarksDTO;
import com.example.school.dto.StudentStandardDTO;
import com.example.school.entity.MarksEntity;
import com.example.school.entity.StudentStandard;
import com.example.school.mapper.StudentStdMapper;
import com.example.school.repository.MarksRepository;
import com.example.school.repository.StudentStdRepository;
import com.example.school.service.StudentStdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentStdServiceImpl implements StudentStdService {

    @Autowired
    StudentStdRepository studentStdRepository;

    @Autowired
    MarksRepository marksRepository;

    @Override
    public StudentStandardDTO addStudStd(StudentStandardDTO studentStandardDTO) {
        StudentStandard studentStandard ;
        studentStandard = StudentStdMapper.INSTANCE.toStudStdEntity(studentStandardDTO);
        studentStandard = studentStdRepository.save(studentStandard);
        return StudentStdMapper.INSTANCE.toStudStdDto(studentStandard);
    }

    @Override
    public StudentStandardDTO updateStudStd(StudentStandardDTO studentStandardDTO) {
        StudentStandard studentStandard = new StudentStandard();
        studentStandard = studentStdRepository.findById(studentStandardDTO.getRoll_number()).map(res->{
            if(studentStandardDTO.getStudent_id()!=0)
                res.setStudent_id(studentStandardDTO.getStudent_id());
            if(studentStandardDTO.getStandard_id()!=0)
                res.setStandard_id(studentStandardDTO.getStandard_id());
            return res;
        }).get();
        return StudentStdMapper.INSTANCE.toStudStdDto(studentStandard);
    }

    @Override
    public String deleteStudStd(StudentStandardDTO studentStandardDTO) {
        studentStdRepository.deleteById(studentStandardDTO.getRoll_number());
        return "Deleted record: "+ studentStandardDTO.getRoll_number();
    }

    @Override
    public String deleteAllStudStd() {
        studentStdRepository.deleteAll();
        return "Deleted All Records.";
    }

    @Override
    public StudentStandardDTO showStudStd(StudentStandardDTO studentStandardDTO) {
        StudentStandard studentStandard = new StudentStandard();
        studentStandard = studentStdRepository.getById(studentStandardDTO.getRoll_number());
        return StudentStdMapper.INSTANCE.toStudStdDto(studentStandard);
    }

    @Override
    public List<StudentStandardDTO> showAllStudStd() {
        return Optional.of(studentStdRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(StudentStdMapper.INSTANCE::toStudStdDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResultDTO> getResults() {

        List<ResultDTO> resultDTOArrayList = new ArrayList<>();
        List<ResultMarksDTO> AllStudentsMarks = new ArrayList<>();
        List<MarksEntity> marksEntityList = marksRepository.findAll();
        List<StudentStandard> studentStandard=studentStdRepository.findAll();

        marksEntityList.forEach(marks->{
            ResultMarksDTO resultMarksDTO = new ResultMarksDTO();
            String subject = marksRepository.getSubjectName(marks.getSubject_id());
            resultMarksDTO.setStudent_id(marks.getStudent_id());
            resultMarksDTO.setMarks(marks.getMarks());
            resultMarksDTO.setSubject_name(subject);
            if(marks.getMarks()>45)
                resultMarksDTO.setStatus("P");
            else
                resultMarksDTO.setStatus("F");
            AllStudentsMarks.add(resultMarksDTO);

        });

        studentStandard.forEach(student->{

                List<ResultMarksDTO> studentMark = new ArrayList<>();
                AllStudentsMarks.forEach(marks->{
                    ResultMarksDTO resultMarksDTO = new ResultMarksDTO();
                    if(marks.getStudent_id()==student.getStudent_id()){
                        resultMarksDTO.setStudent_id(marks.getStudent_id());
                        resultMarksDTO.setSubject_name(marks.getSubject_name());
                        resultMarksDTO.setMarks(marks.getMarks());
                        resultMarksDTO.setStatus(marks.getStatus());
                        studentMark.add(resultMarksDTO);
                    }
                });


                ResultDTO resultDTO = new ResultDTO();
                int present = marksRepository.getDaysPresent(student.getRoll_number());
                int absent =marksRepository.getDaysAbsent(student.getRoll_number());
                int total = present+absent;
                String status;
                final int[] marksStatus = new int[1];
                int id = student.getRoll_number();
                double attendancePercentage = marksRepository.getAttendancePercentage(id);
                String studentName= marksRepository.getStudentName(id);
                resultDTO.setSubjects(studentMark);
                resultDTO.setRollNo(id);
                resultDTO.setStudent_name(studentName);
                resultDTO.setAttendance_percentage(attendancePercentage);
                resultDTO.setDays_present(present);
                resultDTO.setDays_absent(absent);
                resultDTO.setTotal_working_days(total);
                studentMark.forEach(mark->{

                    if(mark.getStatus()=="F")
                        marksStatus[0] =0;
                    else
                        marksStatus[0] = 1;
                });
                if(marksStatus[0]==1 && attendancePercentage>65)
                    status="P";
                else
                    status="F";
                resultDTO.setStatus(status);
                resultDTOArrayList.add(resultDTO);
        });
        return resultDTOArrayList;
    }


}
