package com.uco.apisolveit.publication.repository.publication;
import com.uco.apisolveit.publication.domain.publication.Publication;
import com.uco.apisolveit.publication.domain.publicationtype.PublicationType;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.Date;
public interface IPublicationRepository extends ReactiveCrudRepository<Publication, String>
{}