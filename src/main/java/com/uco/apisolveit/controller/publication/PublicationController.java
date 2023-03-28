package com.uco.apisolveit.controller.publication;


import com.uco.apisolveit.controller.Response;
import com.uco.apisolveit.domain.publication.Publication;
import com.uco.apisolveit.dto.publication.PublicationDTO;
import com.uco.apisolveit.service.publication.PublicationService;
import com.uco.apisolveit.service.publicationtype.PublicationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rest")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationTypeService publicationTypeService;

    @GetMapping("/publication")
    public ResponseEntity<Response<Publication>> getPublication(){
        ResponseEntity<Response<Publication>> responseEntity;
        List<String> messages = new ArrayList<>();
        Response<Publication> response = new Response<>();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        try{
            response.setData(publicationService.getAll().collectList().block());
            messages.add("All publications");
            statusCode = HttpStatus.OK;
        }catch (Exception exception){
            messages.add(exception.getMessage());
        }
        response.setMessage(messages);
        response.setStatus(statusCode);
        responseEntity = new ResponseEntity<>(response,statusCode);
        return responseEntity;
    }
    @GetMapping("/publication/title/{title}")
    public ResponseEntity<Response<Publication>> getPublicationByTitle(@PathVariable("title") String title){
        ResponseEntity<Response<Publication>> responseEntity;
        List<String> messages = new ArrayList<>();
        List<Publication> publicationList = new ArrayList<>();
        Response<Publication> response = new Response<>();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        try{
            publicationList = publicationService.getByTitle(title).collectList().block();
            if(!publicationList.isEmpty()){
                response.setData(publicationList);
                messages.add("Publications by title");
                statusCode = HttpStatus.OK;
            }else{
                messages.add("No publications found with this title.");
                statusCode = HttpStatus.NOT_FOUND;
            }

        }catch (Exception exception){
            messages.add(exception.getMessage());
        }
        response.setMessage(messages);
        response.setStatus(statusCode);
        responseEntity = new ResponseEntity<>(response,statusCode);
        return responseEntity;
    }

    @GetMapping("/publication/type/{type}")
    public ResponseEntity<Response<Publication>> getPublicationByType(@PathVariable("type") String type){
        ResponseEntity<Response<Publication>> responseEntity;
        List<String> messages = new ArrayList<>();
        List<Publication> publicationList = new ArrayList<>();
        Response<Publication> response = new Response<>();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        try{
            publicationList = publicationService.getByType(publicationTypeService.get(type).block()).collectList().block();
            if(!publicationList.isEmpty()){
                response.setData(publicationList);
                messages.add("Publications by type");
                statusCode = HttpStatus.OK;
            }else{
                messages.add("No publications found with this type");
                statusCode = HttpStatus.OK;
            }

        }catch (Exception exception){
            messages.add(exception.getMessage());
        }
        response.setMessage(messages);
        response.setStatus(statusCode);
        responseEntity = new ResponseEntity<>(response,statusCode);
        return responseEntity;
    }

    @GetMapping("/publication/date/{date}")
    public ResponseEntity<Response<Publication>> getPublicationByDate(@PathVariable("date") Date date){
        ResponseEntity<Response<Publication>> responseEntity;
        List<String> messages = new ArrayList<>();
        Response<Publication> response = new Response<>();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        try{
            response.setData(publicationService.getByDate(date).collectList().block());
            messages.add("Publications by date");
            statusCode = HttpStatus.OK;
        }catch (Exception exception){
            messages.add(exception.getMessage());
        }
        response.setMessage(messages);
        response.setStatus(statusCode);
        responseEntity = new ResponseEntity<>(response,statusCode);
        return responseEntity;
    }
    @GetMapping("/publication/some/{title}/{category}/{date}")
    public ResponseEntity<Response<Publication>> getPublicationBySome(@PathVariable("title") String title,@PathVariable("category") String category,@PathVariable("date") Date date){
        ResponseEntity<Response<Publication>> responseEntity;
        List<String> messages = new ArrayList<>();
        Response<Publication> response = new Response<>();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        try{
            response.setData(publicationService.getBySome(title,category,date).collectList().block());
            messages.add("Publications by title, type and date");
            statusCode = HttpStatus.OK;
        }catch (Exception exception){
            messages.add(exception.getMessage());
        }
        response.setMessage(messages);
        response.setStatus(statusCode);
        responseEntity = new ResponseEntity<>(response,statusCode);
        return responseEntity;
    }

    @PostMapping("/publication")
    public ResponseEntity<Response<Publication>> postPublication(@RequestBody PublicationDTO publicationDTO){
        ResponseEntity<Response<Publication>> responseEntity;
        List<String> messages = new ArrayList<>();
        Response<Publication> response = new Response<>();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        try{
            publicationService.save(Publication.setData(publicationDTO));
            messages.add("Publication created successfully");
            statusCode = HttpStatus.OK;
        }catch (Exception exception){
            messages.add(exception.getMessage());
        }
        response.setMessage(messages);
        response.setStatus(statusCode);
        responseEntity = new ResponseEntity<>(response,statusCode);
        return responseEntity;
    }

    @PutMapping("/publication")
    public ResponseEntity<Response<Publication>> putPublication(@RequestBody String id,PublicationDTO publicationDTO){
        ResponseEntity<Response<Publication>> responseEntity;
        List<String> messages = new ArrayList<>();
        Response<Publication> response = new Response<>();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        try{
            publicationService.put(id,Publication.setData(publicationDTO));
            messages.add("Publication actualized successfully");
            statusCode = HttpStatus.OK;
        }
        catch (Exception exception){
            messages.add(exception.getMessage());
        }
        response.setMessage(messages);
        response.setStatus(statusCode);
        responseEntity = new ResponseEntity<>(response,statusCode);
        return responseEntity;
    }


    @DeleteMapping("/publication")
    public  ResponseEntity<Response<Publication>> deletePublication(@RequestParam String publicationId){
        ResponseEntity<Response<Publication>> responseEntity;
        List<String> messages = new ArrayList<>();
        Response<Publication> response = new Response<>();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        try{
            publicationService.delete(publicationId);
            messages.add("Publication deleted successfully");
            statusCode = HttpStatus.OK;
        }
        catch (Exception exception){
            messages.add(exception.getMessage());
        }
        response.setMessage(messages);
        response.setStatus(statusCode);
        responseEntity = new ResponseEntity<>(response,statusCode);
        return responseEntity;
    }
}