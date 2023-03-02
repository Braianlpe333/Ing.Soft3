package com.uco.apisolveit.controller.publication;

import com.azure.cosmos.implementation.Document;
import com.azure.cosmos.implementation.Strings;
import com.uco.apiaolveit.domain.person.Person;
import com.uco.apiaolveit.domain.publication.Publication;
import com.uco.apiaolveit.service.publication.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/rest")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;




    @GetMapping("/publication")
    public Flux<Publication>getPublication(){
        return publicationService.get();
    }
    @GetMapping("/publication/tittle")
    public Flux<Publication> getPublication(@RequestParam(required = true) String title){
        return publicationService.get(title);
    }
    @GetMapping("/publication/type")
    public Flux<Publication> getPublication(@RequestParam(required = true) String type){
        return publicationService.get(type);
    }
    @GetMapping("/publication/date")
    public Flux<Publication> getPublication(@RequestParam(required = true) Date date){
        return publicationService.get(date);
    }
    @GetMapping("/publication/some")
    public Flux<Publication> getPublication(@RequestParam(required = true) String title, String type, Date date){
        return publicationService.get(title,type,date);
    }
    @GetMapping("/publication/user")
    public Flux<Publication> getPublication(@RequestParam(required = true) String mail){
        return publicationService.get(mail);
    }



    @PostMapping("/publication")
    public Mono<Publication> postPublication(@RequestBody PublicationService publication){
        return publicationService.save(publication);
    }



    @PatchMapping("/publication")
    public PublicationService patchPublication(@RequestBody PublicationService publication){
        return publicationService.patch(publication);
    }


    @DeleteMapping("/publication")
    public  PublicationService deletePublication(@RequestParam(required = true)String publicationId){
        return publicationService.delete(publication);
    }


}
