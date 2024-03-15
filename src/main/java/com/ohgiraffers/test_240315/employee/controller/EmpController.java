package com.ohgiraffers.test_240315.employee.controller;


import com.ohgiraffers.test_240315.employee.model.dto.DepartmentDTO;
import com.ohgiraffers.test_240315.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.test_240315.employee.model.dto.JobDTO;
import com.ohgiraffers.test_240315.employee.model.dto.SalGradeDTO;
import com.ohgiraffers.test_240315.employee.model.service.EmpService;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/emp")
public class EmpController {
    private final EmpService empService;
    private final Logger logger = LoggerFactory.getLogger(EmpController.class);

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/list")
    public String findAllEmp(Model model) {
        List<EmployeeDTO> empList = empService.findAllEmp();
        model.addAttribute("empList", empList);
        return "emp/list";
    }

    @GetMapping("/regist")
    public String registPage() {
        return "emp/regist";
    }

    @PostMapping("/regist")
    public String registEmp(String empName,
                            String empNo1,
                            String empNo2,
                            String email,
                            String  phone,
                            String deptCode,
                            String jobCode,
                            String salLevel,
                            String  salary,
                            String bonus,
                            String managerId
                            ) {
        EmployeeDTO employee = new EmployeeDTO();
        String empNo = empNo1 + "-" + empNo2;
        employee.setEmpName(empName);
        employee.setEmpNo(empNo);
        employee.setEmail(email);
        employee.setDeptCode(deptCode);
        employee.setPhone(Integer.parseInt(phone));
        employee.setJobCode(jobCode);
        employee.setSalLevel(salLevel);
        System.out.println(salLevel);
        int salNum = Integer.parseInt(salary);
        switch (employee.getSalLevel()) {
            case "S1" -> {
                if (salNum > 10000000) salNum = 10000000;
                else if (salNum < 6000000) salNum = 6000000;
            }
            case "S2" -> {
                if (salNum > 5999999) salNum = 5999999;
                else if (salNum < 5000000) salNum = 5000000;
            }
            case "S3" -> {
                if (salNum > 4999999) salNum = 4999999;
                else if (salNum < 4000000) salNum = 4000000;
            }
            case "S4" -> {
                if (salNum > 3999999) salNum = 3999999;
                else if (salNum < 3000000) salNum = 3000000;
            }
            case "S5" -> {
                if (salNum > 2999999) salNum = 2999999;
                else if (salNum < 2000000) salNum = 2000000;
            }
            case "S6" -> {
                if (salNum > 1999999) salNum = 1999999;
                else if (salNum < 1000000) salNum = 1000000;
            }

        }
        employee.setSalary(salNum);
        employee.setBonus(Double.parseDouble(bonus));
        if(managerId.equals("null"))  employee.setManagerId(null);
        employee.setManagerId(Integer.getInteger(managerId));
        employee.setHireDate(new Date(System.currentTimeMillis()));
        employee.setEntYn("N");

        logger.info("emp : {}", employee);


        empService.registEmp(employee);
        return "redirect:/emp/list";
    }

    @GetMapping("/dept")
    public @ResponseBody List<DepartmentDTO> findDeptList() {
        return empService.findDeptList();
    }

    @GetMapping("/job")
    public @ResponseBody List<JobDTO> findJobList() {
        return empService.findJobList();
    }

    @GetMapping("/sal")
    public @ResponseBody List<SalGradeDTO> findSalGradeList() {
        return empService.findSalGradeList();
    }

    @GetMapping("/managerId")
    public @ResponseBody List<String> findManagerIdList() {
        return empService.findManagerIdList();
    }
}
