package com.mps.batch_mps_pushdata.service;

import com.mps.batch_mps_pushdata.dto.EmployeeListDTO;
import com.mps.batch_mps_pushdata.repository.PushRepository;
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
    private KafkaTemplate<String,EmployeeListDTO> kafkaTemplate;
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
