package com.app.electronicShopManagement;

import com.app.electronicShopManagement.domain.product.WashinMachineProgramType;
import com.app.electronicShopManagement.sesrvice.washingMachineService.WashingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ElectronicShopManagementApplication {

	@Autowired
	private WashingMachineService washingMachineService;

	public static void main(String[] args) {


		SpringApplication.run(ElectronicShopManagementApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void afterApplicationStart(){

		washingMachineService.changeProgramType(WashinMachineProgramType.PRELIMINARY_WASHING);
	}

}
