package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {

		System.out.println("inside main method start");
		SpringApplication.run(Spring5webappApplication.class, args);
		System.out.println("inside main method end");
	}
}
