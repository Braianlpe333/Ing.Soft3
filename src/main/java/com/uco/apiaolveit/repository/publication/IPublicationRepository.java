package com.uco.apiaolveit.repository.publication;
import com.uco.apiaolveit.domain.publication.Publication;
import com.uco.apiaolveit.domain.publicationType.PublicationType;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface IPublicationRepository extends ReactiveCrudRepository<Publication, String> {

    @Query("{ 'id': ?0, 'category': ?1}")
    Mono<Publication> findByID(String id, String category);

    @Query("{'title': ?0}")
    Flux<Publication> findByTitle( String title);


    @Query("{'type': ?0}")
    Flux<Publication> findByType( PublicationType type);

    @Query("{date: ?0}")
    Flux<Publication> findBydate(Date date);

    @Query("{title: ?0, type: ?1, date: ?2}")
    Flux<Publication> findByTitleTypeDate(String title, String type, Date date);


}
