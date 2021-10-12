package com.example.school.controller;


import com.example.school.dto.StaffDTO;
import com.example.school.dto.StaffSubjectDTO;
import com.example.school.service.impl.StaffServiceImpl;
import com.example.school.service.impl.StaffSubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    //Staff Bio-data//

    @Autowired
    StaffServiceImpl staffService;

    @PostMapping("/new-staff")
    public ResponseEntity<StaffDTO> addStaff(@RequestBody StaffDTO staffDTO){

        StaffDTO staffDTO1 = new StaffDTO();
        staffDTO1= staffService.addStaff(staffDTO);
        return new ResponseEntity<>(staffDTO1, HttpStatus.OK);
    }

    @PutMapping("/update-staff")
    public  ResponseEntity<StaffDTO> updateStaff(@RequestBody StaffDTO staffDTO){

        StaffDTO staffDTO1 = new StaffDTO();
        staffDTO1= staffService.updateStaff(staffDTO);
        return new ResponseEntity<>(staffDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/staff")
    public ResponseEntity<String> deleteStaff(@RequestBody StaffDTO staffDTO){

        String message = staffService.deleteStaff(staffDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/all-staff")
    public ResponseEntity<String> deleteAllStaff(){

        String message = staffService.deleteAllStaffs();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/single-staff")
    public ResponseEntity<StaffDTO> showStaff(@RequestBody StaffDTO staffDTO){

        StaffDTO staffDTO1 = staffService.showStaff(staffDTO);
        return new ResponseEntity<>(staffDTO1,HttpStatus.OK);
    }

    @GetMapping("/all-staff")
    public ResponseEntity<List<StaffDTO>> showAllStaff(){

        List<StaffDTO> staffDTOS = staffService.showAllStaffs();
        return new ResponseEntity<>(staffDTOS,HttpStatus.OK);

    }

    //Staff Subject//

    @Autowired
    StaffSubjectServiceImpl staffSubjectService;

    @PostMapping("/new_staff_subject")
    public ResponseEntity<StaffSubjectDTO> addStaffSub(@RequestBody StaffSubjectDTO staffSubjectDTO){

        StaffSubjectDTO staffSubjectDTO1 = new StaffSubjectDTO();
        staffSubjectDTO1 = staffSubjectService.addStaffSub(staffSubjectDTO);
        return new ResponseEntity<>(staffSubjectDTO1, HttpStatus.OK);
    }

    @PutMapping("/update_staff_subject")
    public ResponseEntity<StaffSubjectDTO> updateStaffSub(@RequestBody StaffSubjectDTO staffSubjectDTO){

        StaffSubjectDTO staffSubjectDTO1 = new StaffSubjectDTO();
        staffSubjectDTO1 = staffSubjectService.updateStaffSub(staffSubjectDTO);
        return new ResponseEntity<>(staffSubjectDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/staff_subject")
    public ResponseEntity<String> deleteStaffSub(@RequestBody StaffSubjectDTO staffSubjectDTO){

        String message = staffSubjectService.deleteStaffSub(staffSubjectDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/all_staff_subject")
    public ResponseEntity<String> deleteAllStaffSub(){

        String message = staffSubjectService.deleteAllStaffSub();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/single-staff_subject")
    public ResponseEntity<StaffSubjectDTO> showStaffSub(@RequestBody StaffSubjectDTO staffSubjectDTO){

        StaffSubjectDTO staffSubjectDTO1 = new StaffSubjectDTO();
        staffSubjectDTO1 = staffSubjectService.showStaffSub(staffSubjectDTO);
        return new ResponseEntity<>(staffSubjectDTO1,HttpStatus.OK);
    }

    @GetMapping("/all_staff_subject")
    public ResponseEntity<List<StaffSubjectDTO>> showAllStaffSub(){

        List<StaffSubjectDTO> StaffSubjectList = staffSubjectService.showAllStaffSub();
        return new ResponseEntity<>(StaffSubjectList,HttpStatus.OK);
    }
}