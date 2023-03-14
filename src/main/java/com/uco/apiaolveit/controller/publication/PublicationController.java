package com.uco.apiaolveit.controller.publication;


import com.uco.apiaolveit.domain.publication.Publication;
import com.uco.apiaolveit.domain.publicationtype.PublicationType;
import com.uco.apiaolveit.service.publication.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Flux<Publication> getPublication(@RequestParam(required = true) PublicationType type){
        return publicationService.get(type);
    }
    @GetMapping("/publication/date")
    public Flux<Publication> getPublication(@RequestParam(required = true) Date date){
        return publicationService.get(date);
    }
    @GetMapping("/publication/some")
    public Flux<Publication> getPublication(@RequestParam(required = true) String title, PublicationType type, Date date){
        return publicationService.get(title,type,date);
    }

    @PostMapping("/publication")
    public Mono<Publication> postPublication(@RequestBody Publication publication){
        return publicationService.save(publication);
    }

    @PatchMapping("/publication")
    public Mono<Publication> patchPublication(@RequestBody String id,Publication publication){
        return publicationService.patch(id,publication);
    }


    @DeleteMapping("/publication")
    public  Mono<Void> deletePublication(@RequestParam(required = true)String publicationId){
        return publicationService.delete(publicationId);
    }


}
