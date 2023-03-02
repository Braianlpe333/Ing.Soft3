package com.uco.apiaolveit.repository.person;
import com.uco.apiaolveit.domain.person.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IPersonRepository extends ReactiveCrudRepository<Person, String > {

}
