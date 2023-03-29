package com.example.Controller;

import com.example.Entity.Person;
import com.example.Entity.PersonResponse;
import com.example.configuration.Service;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import org.jooq.DSLContext;


@Controller("/api")
public class PersonController {
    @Inject
    DSLContext dslContext;
    @Inject
    Service service;

    @Get("/person")
    public HttpResponse<?> allPersons(){
        PersonResponse person = service.getPerson();
        System.out.println(person.getId() + " " + person.getName() + " " + person.getSurname() + " " + person.getAge());
        return HttpResponse.noContent();

    }
}
