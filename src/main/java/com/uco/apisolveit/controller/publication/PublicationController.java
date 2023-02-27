package com.uco.apisolveit.controller.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/rest")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;




    @GetMapping("/publication")
    public PublicationService getPublication(){
        return publicationService.get();
    }
    @GetMapping("/publication")
    public PublicationService getPublication(@RequestBody String title){
        return publicationService.get(title);
    }
    @GetMapping("/publication")
    public PublicationService getPublication(@RequestBody String type){
        return publicationService.get(type);
    }
    @GetMapping("/publication")
    public PublicationService getPublication(@RequestBody Date date){
        return publicationService.get(date);
    }
    @GetMapping("/publication")
    public PublicationService getPublication(@RequestBody String title, String type, Date date){
        return publicationService.get(title,type,date);
    }


    @PostMapping("/publication")
    public PublicationService postPublication(@RequestBody PublicationService publication){
        return publicationService.post(publication);
    }



    @PatchMapping("/publication")
    public PublicationService patchPublication(@RequestBody PublicationService publication){
        return publicationService.patch(publication);
    }


    @deleteMapping("/publication")
    public  PublicationService deletePublication(@Valid @RequestBody PublicationService publication){
        return publicationService.delete(publication);
    }


}
