package com.uco.apisolveit.repository.type;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.uco.apisolveit.domain.publicationtype.PublicationType;



public interface IPublicationTypeRepository extends ReactiveCrudRepository<PublicationType,String>
{
}
