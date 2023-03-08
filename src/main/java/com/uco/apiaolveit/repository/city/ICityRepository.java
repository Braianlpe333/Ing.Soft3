package com.uco.apiaolveit.repository.city;

import com.uco.apiaolveit.domain.city.City;
import com.uco.apiaolveit.domain.person.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ICityRepository extends ReactiveCrudRepository<City, String > {
}
