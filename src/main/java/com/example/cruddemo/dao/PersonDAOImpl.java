package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Person;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
