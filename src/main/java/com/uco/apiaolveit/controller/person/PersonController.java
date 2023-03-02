package com.uco.apisolveit.controller.person;

import com.uco.apiaolveit.domain.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/rest")
public class PersonController {
    @Autowired
    private UserService userService;

    @GetMapping("/usuario")
    public Person getPerson(@RequestBody String email){
        return userService.get(email);
    }

    @PostMapping("/usuario")
    public Person postPerson(@Valid @RequestBody Person person){
        return userService.save(person);
    }

    @PatchMapping("/usuario")
    public Person patchPerson(@Valid @RequestBody Person person){
        return userService.patch(person);
    }

    @deleteMapping("/usuario")
    public Person deletePerson(@Valid @RequestBody Person person){
        return userService.delete(person);
    }
}
