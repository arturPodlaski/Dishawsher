package com.app.electronicShopManagement.domain.employee;

import com.app.electronicShopManagement.department.DepartmentCategory;
import lombok.*;

import java.math.BigDecimal;


@NoArgsConstructor
@Builder
@Data
@ToString
@AllArgsConstructor
public class Employee {

    private String name;
    private String surname;
    private Integer age;
    private BigDecimal salary;
    private DepartmentCategory departmentCategory;
}
