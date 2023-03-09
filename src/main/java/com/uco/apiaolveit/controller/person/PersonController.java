package com.uco.apiaolveit.controller.person;

import com.uco.apiaolveit.domain.person.Person;
import com.uco.apiaolveit.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/rest")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/usuario")
    public Mono<Person> getPerson(@RequestBody String email){
        return personService.get(email);
    }

    @PostMapping("/usuario")
    public Mono<Person> postPerson(@Valid @RequestBody Person person){
        return personService.save(person);
    }

    @PatchMapping("/usuario")
    public Mono<Person> patchPerson(@Valid @RequestBody String email, Person person){
        return personService.patch(email,person);
    }

    @DeleteMapping("/usuario")
    public Mono<Void> deletePerson(@Valid @RequestBody String email){
        return personService.delete(email);
    }
}
