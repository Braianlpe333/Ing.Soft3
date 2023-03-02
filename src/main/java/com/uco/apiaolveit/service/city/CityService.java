package com.uco.apiaolveit.service.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public CityRepository get() {
        return cityRepository.findAll();
    }

}
