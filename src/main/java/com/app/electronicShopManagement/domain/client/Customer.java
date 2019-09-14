package com.app.electronicShopManagement.domain.client;


import com.app.electronicShopManagement.domain.product.WashingMachine;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Builder
@Data
@ToString
@AllArgsConstructor
public class Customer {

    private String name;
    private String surName;
    private Integer age;
    private Integer id;
    private BigDecimal cash;
    private List<WashingMachine> listOfProducts;

}
