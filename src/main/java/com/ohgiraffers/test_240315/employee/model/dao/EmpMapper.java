package com.ohgiraffers.test_240315.employee.model.dao;

import com.ohgiraffers.test_240315.employee.model.dto.DepartmentDTO;
import com.ohgiraffers.test_240315.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.test_240315.employee.model.dto.JobDTO;
import com.ohgiraffers.test_240315.employee.model.dto.SalGradeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<EmployeeDTO> findAllEmp();

    List<DepartmentDTO> findDeptList();

    List<JobDTO> findJoblist();

    List<SalGradeDTO> findSalGradeList();

    List<String> findManagerIdList();

    void registEmp(EmployeeDTO employee);
}
