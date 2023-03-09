package com.uco.apiaolveit.repository.person;
import com.uco.apiaolveit.domain.person.Person;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
public interface IPersonRepository extends ReactiveCrudRepository<Person, String >
{
    @Query("{'email': ?0}")
    Mono<Person> findByEmail(String email);
}
