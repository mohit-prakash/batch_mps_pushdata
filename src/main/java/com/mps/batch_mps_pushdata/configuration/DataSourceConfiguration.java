package com.mps.batch_mps_pushdata.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "mysqlclassicmodels.datasource")
    public DataSource mySqlDataSource(@Value("${mysqlclassicmodels.datasource.url}") String url){
        log.info("Datasource Url: "+url);
        return DataSourceBuilder.create()
                .url(url)
                .username("root")
                .password("password")
                .build();
    }
    @Bean
    public NamedParameterJdbcTemplate getMysqlJdbcTemplate(@Qualifier("mySqlDataSource") DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
