package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    //define fields for entity manager

    private EntityManager entityManager;
    //inject entity manager using constructor injection

    @Autowired
    public PersonDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method

    @Override
    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    public Person findById(Integer id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> findAll() {
        // create query

        //Person is name of JPA Entity the class name. NOT the name of the database table.
        //All JPQL syntax is based on entity name and entity fields
        //TypedQuery<Person> theQuery = entityManager.createQuery("FROM Person order by lastName", Person.class);
        TypedQuery<Person> theQuery = entityManager.createQuery("FROM Person", Person.class);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Person> findByLastname(String theLastName) {
        //create query
        TypedQuery<Person> theQuery= entityManager.createQuery("FROM Person WHERE lastName=:theData",Person.class);

        //set query parameters
    theQuery.setParameter("theData",theLastName);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Person thePerson) {
        entityManager.merge(thePerson);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Person thePerson= entityManager.find(Person.class, id);
        entityManager.remove(thePerson);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Person").executeUpdate();
        return numRowsDeleted;
    }
}
