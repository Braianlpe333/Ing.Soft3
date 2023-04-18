package com.uco.apisolveit.controller.identificationtype;

import com.uco.apisolveit.domain.identificationtype.IdentificationType;
import com.uco.apisolveit.repository.identificationtype.IIdentificationType;
import com.uco.apisolveit.service.identificationtype.IdentificationTypeService;
import com.uco.apisolveit.util.Constant;
import com.uco.apisolveit.util.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class IdentificationTypeController {

    @Autowired
    private IdentificationTypeService identificationTypeService;

    @GetMapping("/identificationType")
    public Flux<IdentificationType> get(){
        return identificationTypeService.get();
    }

    @GetMapping("/identificationType/{description}")
    public Mono<IdentificationType> get(@PathVariable("description") String description){return identificationTypeService.get(description);}

}
