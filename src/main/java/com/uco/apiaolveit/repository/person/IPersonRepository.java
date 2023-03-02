package com.uco.apiaolveit.repository.person;
import com.uco.apiaolveit.domain.person.Person;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IPersonRepository extends ReactiveCrudRepository<Person, String > {
    @Query("{ 'id': ?0, 'email': ?1}")
    Mono<Person> findByDocument(String id, String email);
}
