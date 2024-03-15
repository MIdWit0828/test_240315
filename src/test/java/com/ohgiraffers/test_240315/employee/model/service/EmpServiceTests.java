package com.ohgiraffers.test_240315.employee.model.service;


import com.ohgiraffers.test_240315.configuration.Test240315Application;
import com.ohgiraffers.test_240315.employee.controller.EmpController;
import com.ohgiraffers.test_240315.employee.model.dto.DepartmentDTO;
import com.ohgiraffers.test_240315.employee.model.dto.EmployeeDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {Test240315Application.class})
public class EmpServiceTests {

    @Autowired
    private EmpService empService;

    @Test
    void 전체매뉴_조회용_서비스() {
        List<EmployeeDTO> list = empService.findAllEmp();
        assertNotNull(list);
    }

    @Test
    void 부서관리코드_조회_서비스() {
        List<DepartmentDTO> list = empService.findDeptList();
        assertNotNull(list);
    }
}
