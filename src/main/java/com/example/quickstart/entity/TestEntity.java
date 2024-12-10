package com.example.quickstart.entity;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "test")
@Data
@NoArgsConstructor
public class TestEntity {

    @Id
    private String id;

    private String userinfo;

    private String companyName;

    private String location;

    private String position;

    private LocalDateTime interviewTime;


}
