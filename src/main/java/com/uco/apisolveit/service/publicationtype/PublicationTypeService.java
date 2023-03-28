package com.uco.apisolveit.service.publicationtype;

import com.uco.apisolveit.domain.person.Person;
import com.uco.apisolveit.domain.publicationtype.PublicationType;
import com.uco.apisolveit.repository.publicationtype.IPublicationTypeRepository;
import com.uco.apisolveit.util.Constant;
import com.uco.apisolveit.util.UtilObject;
import com.uco.apisolveit.util.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.ValidationException;
import java.util.Objects;

@Service
public class PublicationTypeService {
    @Autowired
    private IPublicationTypeRepository publicationTypeRepository;

    public Flux<PublicationType> get() {
        return publicationTypeRepository.findAll();
    }

    public Mono<PublicationType> get(String publicationTypeId) {
        if(!Objects.isNull(publicationTypeId)){
            UtilString.requieresNoNullOrNoEmpty(publicationTypeId,String.format(Constant.TXT_EXPECT_VALUE, publicationTypeId));
        }
        return publicationTypeRepository.findByCategory(publicationTypeId);
    }

    private void validationData(PublicationType publicationType) {
        UtilString.requieresNoNullOrNoEmpty(publicationType.getDescription(), String.format(Constant.TXT_EXPECT_VALUE, publicationType.getDescription()));
    }
}
