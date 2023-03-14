package com.uco.apiaolveit.controller.type;
import com.uco.apiaolveit.domain.publicationtype.PublicationType;
import com.uco.apiaolveit.service.type.PublicationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/rest")
public class PublicationTypeController {
    @Autowired
    private PublicationTypeService typeService;

    @GetMapping("/publicationType")
    public Flux<PublicationType> get(){
        return typeService.get();
    }
    @GetMapping("/publicationType/{id}")
    public Mono<PublicationType> get(String publicationTypeId){
        return typeService.get(publicationTypeId);
    }

}