package com.uco.apiaolveit.controller.city;

import com.uco.apiaolveit.domain.city.City;
import com.uco.apiaolveit.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/rest")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/City")
    public Flux<City> get(){
        return cityService.get();
    }

    @GetMapping("/City/One")
    public Mono<City> get(@RequestBody String cityId){

        return cityService.get(cityId);
    }
}
