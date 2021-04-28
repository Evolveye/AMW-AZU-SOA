package pl.amw.gdynia.lab3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.amw.gdynia.lab3.wsdl.SayHelloResponse;

@SpringBootApplication
public class Lab3Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab3Application.class, args);
	}

	@Bean
	CommandLineRunner sohdfuisdhfduis(Client client) {
		return args -> {
			SayHelloResponse response = client.getName("Pawel");

			System.out.println("\n= = = =");
			System.out.println(response.getGreeting());
			System.out.println("= = = =");
		};
	}
}
