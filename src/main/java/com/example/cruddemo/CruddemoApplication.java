package com.example.cruddemo;

import com.example.cruddemo.dao.PersonDAO;
import com.example.cruddemo.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Slf4j
@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonDAO personDAO){

		return runner -> {
			//	createPerson(personDAO);

			//	createMultiplePerson(personDAO);

			//	readPerson(personDAO);

				queryForPeople(personDAO);

			//	queryForPeopleByLastName(personDAO);
			//	updatePerson(personDAO);
			//	deletePerson(personDAO);
			//	deleteAll(personDAO);
		};
	}

	private void deleteAll(PersonDAO personDAO) {

		log.info("Deleting all people ...");
		int numRowsDeleted = personDAO.deleteAll();

		log.info("Deleted row count: "+numRowsDeleted);
	}

	private void deletePerson(PersonDAO personDAO) {
		//delete the person
		int personId=6;
		log.info("Deleting person id:"+personId);
		personDAO.delete(personId);

	}

	private void updatePerson(PersonDAO personDAO) {
		//retrive person based on the id: primary key

		int personId = 4;
		log.info("Getting person with id: " + personId);

		Person myPerson =personDAO.findById(personId);

		log.info("Updating person ...");
		//change first name to "Ali"
		myPerson.setFirstName("Ali");
		personDAO.update(myPerson);

		//display updated person
		log.info("Updated person: "+myPerson);
	}

	private void queryForPeopleByLastName(PersonDAO personDAO) {

		//get a list of people
		List<Person> thePeople = personDAO.findByLastname("Eken");

		//display list of people
		for(Person tempPerson : thePeople){
			log.info(String.valueOf(tempPerson));
		}

	}

	private void queryForPeople(PersonDAO personDAO) {

		//get a list of people
		List<Person> thePeople = personDAO.findAll();

		//display list of people
		for(Person tempPerson : thePeople) {
			log.info(String.valueOf(tempPerson));
		}


	}

	private void readPerson(PersonDAO personDAO) {

		//create a person
		log.info("Creating new person object ...");
		Person tempPerson = new Person("Daffy", "Duck", "daffyduck@warnerbros.com");


		//save the person

		log.info("Saving the person ...");
		personDAO.save(tempPerson);

		//display id of the saved person

		int theId = tempPerson.getId();
		log.info("Saved person. Generated id: " + theId);

		//retrive person based on the id: primary key

		log.info("Retrieving person with id: " + theId);
		Person myPerson = personDAO.findById(theId);

		//display person

		log.info("Found the person: " + myPerson);


	}

	private void createMultiplePerson(PersonDAO personDAO) {

		//create multiple person
		log.info("Creating 3 person object ...");
		Person tempPerson1 = new Person("Ali","Yurtseven","aliyurtseven@gmail.com");
		Person tempPerson2 = new Person("Ahmet","Toprak","ahmettoprak@gmail.com");
		Person tempPerson3 = new Person("Esra","Eken","esraeken@gmail.com");

		//save the person objects
		log.info("Saving people ...");
		personDAO.save(tempPerson1);
		personDAO.save(tempPerson2);
		personDAO.save(tempPerson3);

		//display id of the saved people
		log.info("Saved 3 people. Generated ids: " + tempPerson1.getId()  + "-" + tempPerson2.getId() + "-" + tempPerson3.getId());


	}


	private void createPerson(PersonDAO personDAO) {

		//create the person object
		log.info("Creating new person object ...");
		Person tempPerson = new Person("Mickey","Mouse","mickeymouse@mousemail.com");

		//save the person object
		log.info("Saving the person ...");
		personDAO.save(tempPerson);

		//display id of the saved person
		log.info("Saved person. Generated id: " + tempPerson.getId());

	}
}
