package com.uco.apiaolveit.controller.person;

import com.uco.apiaolveit.domain.person.Person;
import com.uco.apiaolveit.dto.person.PersonDTO;
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

    @GetMapping("/user/{email}")
    public Mono<Person> getPerson(@PathVariable("email") String email){
        return personService.get(email);
    }

    @PostMapping("/user")
    public Mono<Person> postPerson(@Valid @RequestBody PersonDTO personDTO){
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setPassword(personDTO.getPassword());
        person.setPhone(personDTO.getPhone());
        person.setEmail(personDTO.getEmail());
        person.setEmploymentField(personDTO.getEmploymentField());
        return personService.save(person);
    }

    @PutMapping("/user")
    public Mono<ResponseEntity<Person>> putPerson( @RequestParam String email,@Valid @RequestBody PersonDTO personDTO){
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setPassword(personDTO.getPassword());
        person.setPhone(personDTO.getPhone());
        person.setEmail(personDTO.getEmail());
        person.setEmploymentField(personDTO.getEmploymentField());
        return personService.patch(email,person).map(updatePerson -> new ResponseEntity<>(updatePerson, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/user")
    public Mono<Void> deletePerson(@Valid @RequestBody String email){
        return personService.delete(email);
    }
}
