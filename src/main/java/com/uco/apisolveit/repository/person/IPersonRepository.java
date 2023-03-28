package com.uco.apisolveit.repository.person;
import com.uco.apisolveit.domain.person.Person;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.security.access.PermissionCacheOptimizer;
import reactor.core.publisher.Mono;
public interface IPersonRepository extends ReactiveCrudRepository<Person, String >
{
    @Query("{'email': ?0}")
    Mono<Person> findByEmail(String email);

}