package iSergio.Reto03C3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@EntityScan(basePackages = {"iSergio.Reto03C3.model"})
@SpringBootApplication
public class Reto03C3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto03C3Application.class, args);
	}

}
