package com.app.electronicShopManagement.sesrvice.washingMachineService;

import com.app.electronicShopManagement.domain.product.WashinMachineProgramType;
import com.app.electronicShopManagement.domain.product.WashingMachine;
import com.app.electronicShopManagement.domain.product.WashingMachineType;
import com.app.electronicShopManagement.domain.product.WashingMmachinePrograms;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@Service
public class WashingMachineService implements WashingMmachinePrograms {

    private WashingMachine washingMachine;
    private Map<String, Map<String, Double>> programTypeParameter; // kluczem w mapie bedzie nazwa zmiennej w klasie washing machine a wartościa bedzie wartość do tego pola

    @PostConstruct
    public void init() throws IOException {

        programTypeParameter = new HashMap<>();// enummapy sa szybsze od wszsytskich map, dzieki temu ze maja jako klucz enum

        washingMachine = WashingMachine.builder()
                .name("Frania")
                .model("x5")
                .energyConsumption(240.0)
                .price(new BigDecimal(400))
                .waterTemperature(40.0)
                .washingMachineType(WashingMachineType.STANDARD_SIZE)
                .washinMachineProgramType(WashinMachineProgramType.PRELIMINARY_WASHING)
                .build();

        File file = ResourceUtils.getFile("classpath:washingMachineProperties.json");// czytanie z pliku json który znajduje sie w folderze rosurces

        programTypeParameter = new ObjectMapper().readValue(file, programTypeParameter.getClass());

        System.out.println(programTypeParameter);
    }


    @Override
    public void changeProgramType(WashinMachineProgramType washinMachineProgramType) {

        washingMachine.setWashinMachineProgramType(washinMachineProgramType);

        Map<String, Double> parameters = programTypeParameter.get(washinMachineProgramType.name()); // funkcja name() to string z nazwy eenuma
        Arrays.asList(washingMachine.getClass().getDeclaredFields()).forEach(field -> {

            Double value = parameters.get(field.getName());
            if (value != null) {
                field.setAccessible(true); // pole jest dostępne tzn nie jest prywatne
                try {
                    field.set(washingMachine, value); //w parametrach ustawiamy obiekt i wartość jakie maja sie zmienic
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });


        System.out.println(washingMachine);
    }
}
