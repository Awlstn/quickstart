package com.example.quickstart.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InterviewDto {

    private String companyName;

    private String location;

    private String position;

    private LocalDateTime interviewTime;
}
