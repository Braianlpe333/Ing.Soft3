package com.uco.apisolveit.publication.repository.publicationtype;

import com.uco.apisolveit.publication.domain.publicationtype.PublicationType;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IPublicationTypeRepository extends ReactiveCrudRepository<PublicationType, String> {

    @Query("{'description': ?0}")
    Mono<PublicationType> findByCategory(String description);
}
