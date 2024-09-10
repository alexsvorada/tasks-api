package eu.svorada.alex.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoAppApplication {

	//TODO Add logging code-wide
	//TODO Add validation for Task entity
	//TODO Add h2 database and tests
	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

}
