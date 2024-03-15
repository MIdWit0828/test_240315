package com.ohgiraffers.test_240315.employee.model.dto;

import ch.qos.logback.core.sift.AppenderTracker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class JobDTO {
    private String jobCode;
    private String jobName;

    public JobDTO() {
    }
}
