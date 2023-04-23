package com.example.cruddemo;

import com.example.cruddemo.dao.PersonDAO;
import com.example.cruddemo.entity.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonDAO personDAO){

		return runner -> {
			createPerson(personDAO);

		};
	}
	private void createPerson(PersonDAO personDAO) {

		//create the person object
		System.out.println("Creating new person object ...");
		Person tempPerson = new Person("Mickey","Mouse","mickeymouse@mousemail.com");

		//save the person object
		System.out.println("Saving the person ...");
		personDAO.save(tempPerson);

		//display id of the saced person
		System.out.println("Saved person. Generated id: " + tempPerson.getId());

	}
}
