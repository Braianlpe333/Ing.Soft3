package com.uco.apiaolveit.repository.publication;
import com.uco.apiaolveit.domain.publication.Publication;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IPublicationRepository extends ReactiveCrudRepository<Publication, String> {

}
