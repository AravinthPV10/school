package com.example.school.controller;

import com.example.school.dto.AttnResDTO;
import com.example.school.dto.StaffAttendanceDTO;
import com.example.school.service.impl.StaffAttendanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff-attendance")
public class StaffAttendanceController {

    //Staff Attendance//

    @Autowired
    StaffAttendanceServiceImpl staffAttendanceService;

    @PostMapping("/new-attendance")
    public ResponseEntity<StaffAttendanceDTO> addStaffAttn(@RequestBody StaffAttendanceDTO staffAttendanceDTO){

        StaffAttendanceDTO staffAttendanceDTO1 = new StaffAttendanceDTO();
        staffAttendanceDTO1 = staffAttendanceService.addStaffAttn(staffAttendanceDTO);
        return new ResponseEntity<>(staffAttendanceDTO1, HttpStatus.OK);
    }

    @PutMapping("/update-attendance")
    public ResponseEntity<StaffAttendanceDTO> updateStaffAttn(@RequestBody StaffAttendanceDTO staffAttendanceDTO){

        StaffAttendanceDTO staffAttendanceDTO1 = new StaffAttendanceDTO();
        staffAttendanceDTO1 = staffAttendanceService.updateStaffAttn(staffAttendanceDTO);
        return new ResponseEntity<>(staffAttendanceDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/attendance")
    public ResponseEntity<String> deleteStaffAttn(@RequestBody StaffAttendanceDTO staffAttendanceDTO){

        String message = staffAttendanceService.deleteStaffAttn(staffAttendanceDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/all-attendance")
    public ResponseEntity<String> deleteAllStaffAttn(){

        String message = staffAttendanceService.deleteAllStaffAttn();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/single-attendance")
    public ResponseEntity<StaffAttendanceDTO> showStaffAttn(@RequestBody StaffAttendanceDTO staffAttendanceDTO){

        StaffAttendanceDTO staffAttendanceDTO1 = staffAttendanceService.showStaffAttn(staffAttendanceDTO);
        return new ResponseEntity<>(staffAttendanceDTO1,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StaffAttendanceDTO>> showAllStaffAttn(){

        List<StaffAttendanceDTO> attendanceList = staffAttendanceService.showAllStaffAttn();
        return new ResponseEntity<>(attendanceList,HttpStatus.OK);
    }

    //Staff Attendance Average//

    @GetMapping("/attendance-percentage/{id}")
    public ResponseEntity<AttnResDTO> attnAvg(@PathVariable("id") int id){

        AttnResDTO attendancePercentage = new AttnResDTO();
        attendancePercentage= staffAttendanceService.getStaffAttendance(id);
        return new ResponseEntity<>(attendancePercentage,HttpStatus.OK);
    }
}