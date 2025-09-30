package com.umc_study.mission_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MissionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MissionServerApplication.class, args);
	}

}
