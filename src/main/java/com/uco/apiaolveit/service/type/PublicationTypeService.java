package com.uco.apiaolveit.service.type;

import com.uco.apiaolveit.domain.publicationtype.PublicationType;
import com.uco.apiaolveit.repository.type.IPublicationTypeRepository;
import com.uco.apiaolveit.util.Constant;
import com.uco.apiaolveit.util.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class PublicationTypeService {
    @Autowired
    private IPublicationTypeRepository publicationTypeRepository;

    public Flux<PublicationType> get(){return  publicationTypeRepository.findAll();}
    public Mono<PublicationType> get(String publicationTypeId){
        if(!Objects.isNull(publicationTypeId)){
            UtilString.requieresNoNullOrNoEmpty(publicationTypeId,String.format(Constant.TXT_EXPECT_VALUE, publicationTypeId));
        }
        return publicationTypeRepository.findById(!Objects.isNull(publicationTypeId)? publicationTypeId:" ");
    }
}
