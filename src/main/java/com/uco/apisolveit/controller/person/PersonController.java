package com.uco.apisolveit.controller.person;

import com.uco.apisolveit.controller.Response;
import com.uco.apisolveit.domain.person.Person;
import com.uco.apisolveit.dto.person.PersonDTO;
import com.uco.apisolveit.service.person.PersonService;
import com.uco.apisolveit.util.UtilObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/rest")
public class PersonController {
    @Autowired
    private PersonService personService;


    @GetMapping("/user")
    public ResponseEntity<Response<Person>> getPerson(){
        ResponseEntity<Response<Person>> responseEntity;
        List<String> messages = new ArrayList<>();
        Response<Person> response = new Response<>();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;

        try{
            response.setData(personService.get().collectList().block());
            messages.add("OK");
            statusCode = HttpStatus.OK;
        }catch (Exception exception){
            messages.add(exception.getMessage());
        }
        response.setMessage(messages);
        response.setStatus(statusCode);
        responseEntity = new ResponseEntity<>(response,statusCode);

        return responseEntity;
    }
    @GetMapping("/user/{email}")
    public ResponseEntity<Response<Person>> getPerson(@PathVariable("email") String email){
        ResponseEntity<Response<Person>> responseEntity;
        List<String> messages = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        Response<Person> response = new Response<>();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;

        try{
            Person person = personService.get(email).block();
            if(!UtilObject.getUtilObject().isNull(person)){
                personList.add(person);
                response.setData(personList);
                messages.add("Person found successfully");
                statusCode = HttpStatus.OK;
            }else{
                response.setData(personList);
                messages.add("Person not found");
                statusCode = HttpStatus.NOT_FOUND;
            }

        }catch (Exception exception){
            messages.add(exception.getMessage());
        }
        response.setMessage(messages);
        response.setStatus(statusCode);
        responseEntity = new ResponseEntity<>(response,statusCode);
        return responseEntity;
    }

    @PostMapping("/user")
    public ResponseEntity<Response<Person>> postPerson(@Valid @RequestBody PersonDTO personDTO){
        ResponseEntity<Response<Person>> responseEntity;
        List<String> messages = new ArrayList<>();
        Response<Person> response = new Response<>();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        try{
            personService.save(Person.setData(personDTO));
            messages.add("User registered successfully");
            statusCode = HttpStatus.OK;
        }catch (Exception exception){
            messages.add(exception.getMessage());
        }
        response.setMessage(messages);
        responseEntity = new ResponseEntity<>(response,statusCode);
        return responseEntity;
    }

    @PutMapping("/user")
    public Mono<ResponseEntity<Person>> putPerson( @RequestParam String email,@Valid @RequestBody PersonDTO personDTO){
        return personService.put(email,Person.setData(personDTO)).map(updatePerson -> new ResponseEntity<>(updatePerson, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PatchMapping("/user")
    public Mono<ResponseEntity<Person>> patchPerson( @RequestParam String email,@Valid @RequestBody PersonDTO personDTO){
        return personService.patch(email,Person.setData(personDTO)).map(updatePerson -> new ResponseEntity<>(updatePerson, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<Response<Person>> deletePerson(@PathVariable("email") String email){
        ResponseEntity<Response<Person>> responseEntity;
        List<String> messages = new ArrayList<>();
        Response<Person> response = new Response<>();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        try{
            messages.add(personService.delete(email));
            statusCode = HttpStatus.OK;

        }catch (Exception exception){
            messages.add(exception.getMessage());
        }
        response.setMessage(messages);
        response.setStatus(statusCode);
        responseEntity = new ResponseEntity<>(response,statusCode);
        return responseEntity;
    }
}
