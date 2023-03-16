package com.uco.apiaolveit.repository.redperson;

import com.uco.apiaolveit.domain.RedPerson;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IRedPersonRepository extends ReactiveCrudRepository<RedPerson, String> {

    @Query("{ 'username': ?0 }")
    Mono<RedPerson> findByUsername(String username);
}
