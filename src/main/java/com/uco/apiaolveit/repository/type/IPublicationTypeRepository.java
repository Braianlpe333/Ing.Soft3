package com.uco.apiaolveit.repository.type;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.uco.apiaolveit.domain.publicationType.PublicationType;
import org.springframework.stereotype.Repository;


public interface IPublicationTypeRepository extends ReactiveCrudRepository<PublicationType,String>
{
}
