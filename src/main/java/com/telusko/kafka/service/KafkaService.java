package com.telusko.kafka.service;

import com.telusko.kafka.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Course> kafkaTemplate;

    public String sendMessage(Course course){

        kafkaTemplate.send("telusko","course",course);   //any data with that key will go to only that partition

        return "Course message sent to kafka";
    }

}
