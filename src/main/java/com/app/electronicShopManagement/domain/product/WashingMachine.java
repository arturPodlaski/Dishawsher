package com.app.electronicShopManagement.domain.product;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@Builder
@Data
@ToString
@AllArgsConstructor
public class WashingMachine {

    private String name;
    private String model;
    private BigDecimal price;
    private Double waterTemperature;
    private Double energyConsumption;
    private Double lenghtOfWashing;
    private WashingMachineType washingMachineType;
    private WashinMachineProgramType washinMachineProgramType;

}
