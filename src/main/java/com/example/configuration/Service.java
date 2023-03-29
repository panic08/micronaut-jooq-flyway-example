package com.example.configuration;

import com.example.Entity.Person;
import com.example.Entity.PersonResponse;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jooq.DSLContext;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;

@Singleton
public class Service {
    @Inject
    DSLContext dslContext;
    @Transactional
    public List<PersonResponse> getAllPersons(){
        List<PersonResponse> person = dslContext.select().from("person").fetchInto(PersonResponse.class);
        return person;
    }
    @Transactional
    public PersonResponse getCurrentPerson(int id){
        PersonResponse response = dslContext.select().from("person").where("id = "+ id).fetchAnyInto(PersonResponse.class);
        return response;
    }
    @Transactional
    public void createPerson(String name, String surname, int age){
        dslContext.insertInto(table("person")).values(defaultValue(), name, surname, age).execute();

    }

}
