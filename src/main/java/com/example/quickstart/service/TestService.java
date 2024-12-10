package com.example.quickstart.service;

import com.example.quickstart.dto.InterviewDto;
import com.example.quickstart.entity.TestEntity;
import com.example.quickstart.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public List<TestEntity> read(){
        return testRepository.findAll();
    }


    public boolean registerInterview(String token, InterviewDto interviewDto) {
        TestEntity testEntity = new TestEntity();
        testEntity.setUserinfo(token);
        testEntity.setCompanyName(interviewDto.getCompanyName());
        testEntity.setPosition(interviewDto.getPosition());
        testEntity.setLocation(interviewDto.getLocation());
        testEntity.setInterviewTime(interviewDto.getInterviewTime());
        testRepository.save(testEntity);
        return true;
    }
}
