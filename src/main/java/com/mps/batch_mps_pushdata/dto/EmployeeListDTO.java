package com.mps.batch_mps_pushdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeListDTO {
    private List<EmployeeDTO> employees;
}
