package br.edu.infnet.appProntuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppProntuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppProntuarioApplication.class, args);
	}

}
