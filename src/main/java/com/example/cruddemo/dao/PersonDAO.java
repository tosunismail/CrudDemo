package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Person;

import java.util.List;

public interface PersonDAO {
    void save(Person person);

    Person findById(Integer id);

    List<Person> findAll();

    List<Person> findByLastname(String theLastName);

    void update(Person thePerson);

    void delete(Integer id);
}
