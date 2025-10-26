package com.lane.relatorios_api;

import org.springframework.boot.SpringApplication;

import com.lane.relatoriosapi.RelatoriosApiApplication;

public class TestRelatoriosApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(RelatoriosApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
