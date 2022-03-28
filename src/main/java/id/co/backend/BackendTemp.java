package id.co.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BackendTemp {

	public static void main(String[] args) {
		SpringApplication.run(BackendTemp.class, args);
	}

}
