package com.ohgiraffers.test_240315.employee.model.service;

import com.ohgiraffers.test_240315.employee.model.dao.EmpMapper;
import com.ohgiraffers.test_240315.employee.model.dto.DepartmentDTO;
import com.ohgiraffers.test_240315.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.test_240315.employee.model.dto.JobDTO;
import com.ohgiraffers.test_240315.employee.model.dto.SalGradeDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmpService {

    private final EmpMapper empMapper;

    public EmpService(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Transactional(readOnly = true)
    public List<EmployeeDTO> findAllEmp() {
        return empMapper.findAllEmp();
    }

    @Transactional
    public List<DepartmentDTO> findDeptList() {
        return empMapper.findDeptList();
    }

    public List<JobDTO> findJobList() {
        return empMapper.findJoblist();
    }

    public List<SalGradeDTO> findSalGradeList() {
        return empMapper.findSalGradeList();
    }

    public List<String> findManagerIdList() {
        return empMapper.findManagerIdList();
    }

    @Transactional
    public void registEmp(EmployeeDTO employee) {
        empMapper.registEmp(employee);
    }
}
