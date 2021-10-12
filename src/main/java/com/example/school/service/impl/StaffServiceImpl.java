package com.example.school.service.impl;

import com.example.school.dto.StaffDTO;
import com.example.school.entity.StaffEntity;
import com.example.school.mapper.StaffMapper;
import com.example.school.repository.StaffRepository;
import com.example.school.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;

    @Override
    public StaffDTO addStaff(StaffDTO staffDTO) {
        StaffEntity s = new StaffEntity();
        s = StaffMapper.INSTANCE.toStaffEntity(staffDTO);
        s=staffRepository.save(s);
        return StaffMapper.INSTANCE.toStaffDto(s);
    }

    @Override
    public StaffDTO updateStaff(StaffDTO staffDTO) {
        StaffEntity s = new StaffEntity();
        s = staffRepository.findById(staffDTO.getStaffId()).map(res->{
            if(staffDTO.getStaffName()!=null)
                res.setStaffName(staffDTO.getStaffName());
            if (staffDTO.getStaffAge()!=0)
                res.setStaffAge(staffDTO.getStaffAge());
            if(staffDTO.getStaffPhone()!=0)
                res.setStaffPhone(staffDTO.getStaffPhone());
            if(staffDTO.getQual()!=null)
                res.setQual(staffDTO.getQual());
            return res;
        }).get();
        return  StaffMapper.INSTANCE.toStaffDto(s);
    }

    @Override
    public String deleteStaff(StaffDTO staffDTO) {
        staffRepository.deleteById(staffDTO.getStaffId());
        return "Deleted Record :"+staffDTO.getStaffId();
    }

    @Override
    public String deleteAllStaffs() {
        staffRepository.deleteAll();
        return "Deleted All Records. ";
    }

    @Override
    public StaffDTO showStaff(StaffDTO staffDTO) {
        StaffEntity s = new StaffEntity();
        s = staffRepository.findById(staffDTO.getStaffId()).get();
        return StaffMapper.INSTANCE.toStaffDto(s);
    }

    @Override
    public List<StaffDTO> showAllStaffs() {
        return Optional.of(staffRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(StaffMapper.INSTANCE::toStaffDto)
                .collect(Collectors.toList());
    }
}
