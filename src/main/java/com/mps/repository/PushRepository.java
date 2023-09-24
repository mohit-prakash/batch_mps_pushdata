package com.mps.repository;

import com.mps.dto.EmployeeDTO;
import com.mps.dto.EmployeeListDTO;
import com.mps.rowmapper.EmpRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

@Repository
@Slf4j
public class PushRepository {
    private Properties sqlProperties;
    private NamedParameterJdbcTemplate mySqlJdbcTemplate;
    public PushRepository(@Qualifier("sqlQueries") Properties sqlProperties, @Qualifier("mySqlDataSource") DataSource dataSource){
        this.sqlProperties=sqlProperties;
        this.mySqlJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
    }

    public EmployeeListDTO getEmpList(int endsWith){
        String sqlQuery = sqlProperties.getProperty("GET_EMP_DETAILS");
        sqlQuery = sqlQuery+" WHERE employeeNumber like \'%"+endsWith+"\';";
//        sqlQuery = sqlQuery + " \'%2\';";
//        List<EmployeeDTO> employees = mySqlJdbcTemplate.query(sqlQuery, (rs, index) -> {
//            EmployeeDTO employeeDTO = new EmployeeDTO();
//            employeeDTO.setFirstName(rs.getString(0).trim());
//            employeeDTO.setLastName(rs.getString(1).trim());
//            employeeDTO.setEmail(rs.getString(2).trim());
//            return employeeDTO;
//        });
        List<EmployeeDTO> employees = mySqlJdbcTemplate.query(sqlQuery,new EmpRowMapper());
        EmployeeListDTO empList = new EmployeeListDTO();
        empList.setEmployees(employees);
        return empList;
    }
}
