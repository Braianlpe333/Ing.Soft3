package com.uco.apiaolveit.service.publication;

import com.uco.apiaolveit.domain.publication.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

import static com.azure.cosmos.implementation.directconnectivity.rntbd.RntbdConstants.RntbdRequestHeader.Date;

@Service
public class PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

    public Flux<Publication> get() {
        return publicationRepository.findAll();
    }
    public Flux<Publication> get(String title) {
        return publicationRepository.findAll(title);
    }
    public Flux<Publication> get(PublacationType type) {
        return publicationRepository.findAll(type);
    }
    public Flux<Publication> get(Date date) {
        return publicationRepository.findAll(date);
    }
    public Flux<Publication> get(String title, String type, Date date) {
        return publicationRepository.findAll(title,type,date);
    }
    public Flux<Publication> get(String mail) {
        return publicationRepository.findAll();
    }

    public Mono<Publication> save(Publication publication){
        return publicationRepository.save(publication);
    }

}
