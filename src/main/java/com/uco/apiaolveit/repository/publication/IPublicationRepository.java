package com.uco.apiaolveit.repository.publication;
import com.uco.apiaolveit.domain.publication.Publication;
import com.uco.apiaolveit.domain.publicationtype.PublicationType;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
public interface IPublicationRepository extends ReactiveCrudRepository<Publication, String>
{

    @Query("{'category': ?0}")
    Mono<Publication> findByCategory(String category);

    @Query("{'title': ?0}")
    Flux<Publication> findByTitle( String title);


    @Query("{'type': ?0}")
    Flux<Publication> findByType( PublicationType type);

    @Query("{date: ?0}")
    Flux<Publication> findBydate(Date date);

    @Query("{title: ?0, type: ?1, date: ?2}")
    Flux<Publication> findByTitleTypeDate(String title, PublicationType type, Date date);


}
