package com.uco.apiaolveit.repository.city;

import com.uco.apiaolveit.domain.city.City;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ICityRepository extends ReactiveCrudRepository<City,String> {
}
