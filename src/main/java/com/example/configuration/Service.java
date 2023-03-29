package com.example.configuration;

import com.example.Entity.Person;
import com.example.Entity.PersonResponse;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jooq.DSLContext;

import javax.transaction.Transactional;

@Singleton
public class Service {
    @Inject
    DSLContext dslContext;
    @Transactional()
    public PersonResponse getPerson(){
        PersonResponse person = dslContext.selectFrom("person").where("name = 'ANDREY'").fetchAnyInto(PersonResponse.class);
        return person;
    }

}
