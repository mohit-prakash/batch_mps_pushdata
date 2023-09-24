package com.mps.rowmapper;

import com.mps.dto.EmployeeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpRowMapper implements RowMapper<EmployeeDTO> {

    @Override
    public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(rs.getString("firstName").trim());
        employeeDTO.setLastName(rs.getString("lastName").trim());
        employeeDTO.setEmail(rs.getString("email").trim());
        return employeeDTO;
    }
}
