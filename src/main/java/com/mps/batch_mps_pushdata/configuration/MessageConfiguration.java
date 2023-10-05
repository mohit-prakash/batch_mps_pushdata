package com.mps.batch_mps_pushdata.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class MessageConfiguration {
    @Bean
    public NewTopic creatTopic(){
        return TopicBuilder.name("FIRST-TOPIC")
                .partitions(1)
                .replicas(1)
                .build();
    }

}
