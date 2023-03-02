package com.uco.apiaolveit.service.person;

import com.uco.apiaolveit.domain.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Autowired
public class PersonService {
    private PersonRepository personrepository;

    public Flux<Person> get(){
        return personrepository.findAll();
    }
    public Mono<Person> save(Person person){
        return personrepository.save(person);
    }

    public Mono<Void> delete(String mail){
        return personrepository.findBymail(mail).flatMap(existingPerson -> isPersonRepository.deleteByMail(mail));
    }
}
