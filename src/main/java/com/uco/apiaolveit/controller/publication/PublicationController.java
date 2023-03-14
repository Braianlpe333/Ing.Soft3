package com.uco.apiaolveit.controller.publication;


import com.uco.apiaolveit.domain.publication.Publication;
import com.uco.apiaolveit.dto.publication.PublicationDTO;
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
    @GetMapping(value ={"/publication/tittle","/publication/type"})
    public Flux<Publication> getPublication(@RequestParam String title){
        return publicationService.get(title);
    }

    @GetMapping("/publication/date")
    public Flux<Publication> getPublication(@RequestParam Date date){
        return publicationService.get(date);
    }
    @GetMapping("/publication/some")
    public Flux<Publication> getPublication(@RequestParam String title, String category, Date date){
        return publicationService.get(title,category,date);
    }

    @PostMapping("/publication")
    public Mono<Publication> postPublication(@RequestBody PublicationDTO publicationDTO){
        Publication publication = new Publication();
        publication.setId(publicationDTO.getId());
        publication.setPublicationTitle(publicationDTO.getPublicationTitle());
        publication.setDescription(publicationDTO.getDescription());
        publication.setCategory(publicationDTO.getCategory());
        publication.setPhone(publicationDTO.getPhone());
        return publicationService.save(publication);
    }

    @PatchMapping("/publication")
    public Mono<Publication> patchPublication(@RequestBody String id,PublicationDTO publicationDTO){
        Publication publication = new Publication();
        publication.setId(publicationDTO.getId());
        publication.setPublicationTitle(publicationDTO.getPublicationTitle());
        publication.setDescription(publicationDTO.getDescription());
        publication.setCategory(publicationDTO.getCategory());
        publication.setPhone(publicationDTO.getPhone());
        return publicationService.patch(id,publication);
    }


    @DeleteMapping("/publication")
    public  Mono<Void> deletePublication(@RequestParam String publicationId){
        return publicationService.delete(publicationId);
    }


}
