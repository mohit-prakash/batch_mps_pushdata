package com.mps.batch_mps_pushdata.service;

import com.mps.batch_mps_pushdata.dto.EmployeeListDTO;
import com.mps.batch_mps_pushdata.proto.EmployeeEvents;
import com.mps.batch_mps_pushdata.proto.Employees;
import com.mps.batch_mps_pushdata.repository.PushRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@Slf4j
public class PushService {
    @Autowired
    private PushRepository repository;
    //    @Autowired
//    private ProtoBufConverter protoBufConverter;
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
        kafkaTemplate.send("FIRST-TOPIC",empList);
    }

    public void sendEvent(){
//        EmployeeListDTO empList = getEmpList();
        Employees employees = Employees.newBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com")
                .build();
        EmployeeEvents employeeEvents = EmployeeEvents.newBuilder()
                .addEmployees(employees)
                .build();
        kafkaTemplate.send("FIRST-TOPIC",employeeEvents);

    }

//    public void pushPufData() throws JsonProcessingException, InvalidProtocolBufferException {
//        EmployeeListDTO empList = getEmpList();
//        log.info("EmpList: "+empList);
//        ObjectMapper objectMapper = new ObjectMapper();
//        //Set pretty printing of json
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        String json = objectMapper.writeValueAsString(empList);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        log.info(json);
//        Struct struct = protoBufConverter.convertJsonToProtobuf(json);
//        log.info("-------------Protobuf Start---------------");
//        log.info(String.valueOf(struct));
//        log.info("-------------Protobuf End---------------");
//        kafkaTemplate.send("firstTopic",struct);
//    }
}
