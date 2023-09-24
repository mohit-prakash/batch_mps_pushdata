package com.mps.service;

import com.mps.dto.EmployeeListDTO;
import com.mps.repository.PushRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class PushService {
    @Autowired
    private PushRepository repository;
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    private EmployeeListDTO getEmpList(){
        Random random = new Random();
        int nextInt = random.nextInt(10);
        log.info("Generated Random Number is "+nextInt);
        return repository.getEmpList(nextInt);
    }

    public void pushData(){
        EmployeeListDTO empList = getEmpList();
        log.info("EmpList: "+empList);
        kafkaTemplate.send("firstTopic",empList);
    }
}
