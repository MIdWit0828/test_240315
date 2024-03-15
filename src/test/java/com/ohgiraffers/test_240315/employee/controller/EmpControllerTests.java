package com.ohgiraffers.test_240315.employee.controller;

import com.ohgiraffers.test_240315.configuration.Test240315Application;
import com.ohgiraffers.test_240315.employee.model.service.EmpService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@ContextConfiguration(classes = {Test240315Application.class})
public class EmpControllerTests {
    @Autowired
    private EmpController empController;

    private MockMvc mockMvc;

    @BeforeEach
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(empController).build();
    }

    @Test
    void 전체매뉴_조회용_컨트롤러() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/emp/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("emp/list"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void 부서관리코드_조회_컨트롤러() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/emp/dept"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("/emp/regist"));
    }

    @Test
    void 신규사원_등록_컨트롤러() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("empName","김사원");
        params.add("empNo1","123456");
        params.add("empNo2","1234567");
        params.add("email","kim1234@emp.com");
        params.add("phone","01012341234");
        params.add("deptCode","D3");
        params.add("jobCode","J7");
        params.add("salLevel","S6");
        params.add("salary","1");
        params.add("bonus","0.2");
        params.add("managerId","null");


        mockMvc.perform(MockMvcRequestBuilders.post("/emp/regist").params(params))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/emp/list"))
                .andDo(MockMvcResultHandlers.print());
    }
}
