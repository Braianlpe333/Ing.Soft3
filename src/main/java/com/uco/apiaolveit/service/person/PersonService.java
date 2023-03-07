package com.uco.apiaolveit.service.person;

import com.uco.apiaolveit.domain.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.uco.apiaolveit.repository.person.IPersonRepository;

import static com.azure.spring.cloud.service.implementation.kafka.AzureKafkaPropertiesUtils.AzureKafkaPasswordlessPropertiesMapping.clientId;

@Service
public class PersonService {
    @Autowired
    private IPersonRepository personrepository;

    public Mono<Person> get(String email){
        return personrepository.findById(email);
    }
    public Mono<Person> save(Person person){
        return personrepository.save(person);
    }

    public Mono<Person>  patch(String email,Person person){
        return personrepository.findByEmail(email).flatMap(existingClient -> {return personrepository.save(person);});
    }

    public Mono<Void> delete(String mail){
        return personrepository.findById(mail).flatMap(existingPerson -> personrepository.deleteById(mail));
    }
}
