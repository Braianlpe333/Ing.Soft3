package com.uco.apiaolveit.repository.city;

import com.uco.apiaolveit.domain.city.City;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ICityRepository extends ReactiveCrudRepository<City,String> {
    @Query("{'description': ?0}")
    Mono<City> findByName(String description);
}
