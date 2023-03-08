package com.uco.apiaolveit.service.publication;

import com.uco.apiaolveit.domain.person.Person;
import com.uco.apiaolveit.domain.publication.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.uco.apiaolveit.repository.publication.IPublicationRepository;
import com.uco.apiaolveit.domain.publicationType.PublicationType;
import java.util.Date;

import static com.azure.cosmos.implementation.directconnectivity.rntbd.RntbdConstants.RntbdRequestHeader.Date;

@Service
public class PublicationService {
    @Autowired
    private IPublicationRepository publicationRepository;

    public Flux<Publication> get() {
        return publicationRepository.findAll();
    }
    public Flux<Publication> get(String title) {
        return publicationRepository.findByTitle(title);
    }
    public Flux<Publication> get(PublicationType type) {
        return publicationRepository.findByType(type);
    }
    public Flux<Publication> get(Date date) {
        return publicationRepository.findBydate(date);
    }
    public Flux<Publication> get(String title, String type, Date date) {
        return publicationRepository.findByTitleTypeDate(title,type,date);
    }


    public Mono<Publication> save(Publication publication){
        return publicationRepository.save(publication);
    }

    public Mono<Publication>  patch(String publicationId, Publication publication){
        return publicationRepository.findById(publicationId).flatMap(existingClient -> {return publicationRepository.save(publication);});
    }

    public Mono<Void> delete(String publicationId){
        return publicationRepository.findById(publicationId).flatMap(existingPerson -> publicationRepository.deleteById(publicationId));
    }
}
