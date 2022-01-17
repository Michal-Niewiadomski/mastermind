package one.lucky.mastermind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MastermindApplication {

	public static void main(String[] args) {
		SpringApplication.run(MastermindApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@PostMapping(value = "/car", consumes = "application/json", produces = "application/json")
	public String car(@RequestBody Car car1) {
		return String.format("Car color: %s\nCar maker: %s", car1.color, car1.maker);
	}

	public static class Car {
		String color;
		String maker;

		public Car(String color, String maker) {
			this.color = color;
			this.maker = maker;
		}
	}
}
