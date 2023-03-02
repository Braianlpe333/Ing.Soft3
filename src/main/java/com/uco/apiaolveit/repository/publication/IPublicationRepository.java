package com.uco.apiaolveit.repository.publication;
import com.uco.apiaolveit.domain.publication.Publication;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IPublicationRepository extends ReactiveCrudRepository<Publication, String> {

    @Query("{ 'id': ?0, 'category': ?1}")
    Mono<Publication> findByDocument(String id, String category);
}
