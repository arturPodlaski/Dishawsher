package com.app.electronicShopManagement.domain.product;

public interface WashingMmachinePrograms {

    void changeProgramType(WashinMachineProgramType washinMachineProgramType);

}


    /*At the start of the software cycle, user
        must be informed about: the current washing program,
        the length of current program, water temperature for current program, enegry consumption
        for current program. Virtual dishwasher should have at least four different
        washing programs. Each washing program should use parameters as: name,
        length, water temperature, energy consumption*/

   /* for (Field field : washingMachine.getClass().getDeclaredFields()) {
            Object value = field.get(washingMachine);
            System.out.println(value);
            }*/