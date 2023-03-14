package com.uco.apiaolveit.controller.person;

import com.uco.apiaolveit.domain.person.Person;
import com.uco.apiaolveit.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/rest")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/usuario/{email}")
    public Mono<Person> getPerson(@PathVariable("email") String email){
        return personService.get(email);
    }

    @PostMapping("/usuario")
    public Mono<Person> postPerson(@Valid @RequestBody Person person){
        return personService.save(person);
    }

    @PutMapping("/usuario")
    public Mono<ResponseEntity<Person>> putPerson( @RequestParam String email,@Valid @RequestBody Person person){

        return personService.patch(email,person).map(updatePerson -> new ResponseEntity<>(updatePerson, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/usuario")
    public Mono<Void> deletePerson(@Valid @RequestBody String email){
        return personService.delete(email);
    }
}
