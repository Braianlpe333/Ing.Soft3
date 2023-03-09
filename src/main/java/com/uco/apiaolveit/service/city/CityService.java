package com.uco.apiaolveit.service.city;

import com.uco.apiaolveit.domain.city.City;
import com.uco.apiaolveit.repository.city.ICityRepository;
import com.uco.apiaolveit.util.Constant;
import com.uco.apiaolveit.util.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class CityService {
    @Autowired
    private ICityRepository cityRepository;

    public Flux<City> get() {
        return cityRepository.findAll();
    }
    public Mono<City> get(String CityId) {
        if(!Objects.isNull(CityId)){
            UtilString.requieresNoNullOrNoEmpty(CityId,String.format(Constant.TXT_EXPECT_VALUE, CityId));
        }
        return cityRepository.findById(CityId);
    }

}
