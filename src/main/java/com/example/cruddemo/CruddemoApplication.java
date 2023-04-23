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
			//	createPerson(personDAO);
			createMultiplePerson(personDAO);

		};
	}

	private void createMultiplePerson(PersonDAO personDAO) {

		//create multiple person
		System.out.println("Creating 3 person object ...");
		Person tempPerson1 = new Person("Ali","Yurtseven","aliyurtseven@gmail.com");
		Person tempPerson2 = new Person("Ahmet","Toprak","ahmettoprak@gmail.com");
		Person tempPerson3 = new Person("Esra","Eken","esraeken@gmail.com");

		//save the person objects
		System.out.println("Saving people ...");
		personDAO.save(tempPerson1);
		personDAO.save(tempPerson2);
		personDAO.save(tempPerson3);

	}


	private void createPerson(PersonDAO personDAO) {

		//create the person object
		System.out.println("Creating new person object ...");
		Person tempPerson = new Person("Mickey","Mouse","mickeymouse@mousemail.com");

		//save the person object
		System.out.println("Saving the person ...");
		personDAO.save(tempPerson);

		//display id of the saved person
		System.out.println("Saved person. Generated id: " + tempPerson.getId());

	}
}
