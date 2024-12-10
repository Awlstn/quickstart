package com.example.quickstart.controller;

import com.example.quickstart.dto.InterviewDto;
import com.example.quickstart.dto.ItemDto;
import com.example.quickstart.dto.ResponseDto;
import com.example.quickstart.entity.TestEntity;
import com.example.quickstart.service.QuickService;
import com.example.quickstart.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j //Lombok 확인
@RequiredArgsConstructor
public class QuickController {

    @Autowired
    private QuickService quickService;

    private final TestService testService;

    @GetMapping("/dummy")
    public String dummy(){
        log.info("dummy");
        return "{}";
    }

//    @GetMapping("/dummy2")
//    public String dummy2(){
//        log.info("dummy2");
//        return "dummy2";
//    }

    @GetMapping("/dummy2")
    public List<Map<String, String>> dummy2() {
        log.info("dummy2");

        List<Map<String, String>> responseList = new ArrayList<>();

        Map<String, String> questionAnswer1 = new HashMap<>();
        questionAnswer1.put("질문1", "답변1");
        responseList.add(questionAnswer1);

        Map<String, String> questionAnswer2 = new HashMap<>();
        questionAnswer2.put("질문2", "답변2");
        responseList.add(questionAnswer2);

        return responseList;
    }

    @GetMapping("/member")
    public String getMember(@RequestParam("empnumber") String empNo, @RequestParam("year") int year){
        log.info("empNo: {}", empNo);
        log.info("year: {}", year);
        return "ok";
    }

    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable("id") String id){
        log.info("id: {}", id);
        //log.info("year: {}", year);
        return "ok";
    }

    @GetMapping("/company2/{id}/{name}")
    public String getCompany2(@PathVariable("id") String id, @PathVariable("name") String name){
        log.info("id: {}", id);
        log.info("name: {}", name);
        return "ok";
    }

    /*
    @PostMapping("/itme")
    public ResponseDto registerItem(@RequestBody ItemDto item){
        log.info("item: {}", item);
        log.info("id: {}", item.getId());
        log.info("name: {}", item.getName());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("ok");
        return responseDto;
    }
     */

    @PostMapping("/itme")
    public ResponseDto registerItem(@RequestBody ItemDto item){
        log.info("item: {}", item);

        //QuickService quickService = new QuickService(); // Autowired 사용하면 됌
        boolean b = quickService.registerItem(item);
        if(b == true){
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("ok");
            return responseDto;
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        return responseDto;
    }

    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id){
        ItemDto res = quickService.getItemById(id);
        return res;
    }

    @GetMapping("/test")
    public List<TestEntity> read(){
        return testService.read();
    }

    @PostMapping("/test")
    public ResponseDto registerInterview(@RequestParam String token, @RequestBody InterviewDto interviewDto){
        boolean b = testService.registerInterview(token, interviewDto);
        if(b){
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("ok");
            return responseDto;
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        return responseDto;
    }




}
