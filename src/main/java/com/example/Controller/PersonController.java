package com.example.Controller;

import com.example.Entity.Person;
import com.example.Entity.PersonResponse;
import com.example.configuration.Service;
import com.google.gson.Gson;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import org.jooq.DSLContext;

import java.util.ArrayList;
import java.util.List;


@Controller("/api")
public class PersonController {
    @Inject
    DSLContext dslContext;
    @Inject
    Service service;

    @Get("/person")
    public HttpResponse<?> allPersons(){
        return HttpResponse.ok().body(service.getAllPersons());
    }
    @Get("/person/{id}")
    public HttpResponse<?> currentPerson(@QueryValue int id){
        return HttpResponse.ok().body(service.getCurrentPerson(id));
    }


    //not working
    @Post("/person/new")
    public HttpResponse<?> createPerson(@Body Person person){
    service.createPerson(person.getName(), person.getSurname(), person.getAge());
    return HttpResponse.noContent();
    }

}
