package com.uco.apisolveit.publication.service.publication;

import com.uco.apisolveit.publication.domain.publication.Publication;
import com.uco.apisolveit.publication.util.Constant;
import com.uco.apisolveit.publication.util.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.uco.apisolveit.publication.repository.publication.IPublicationRepository;


@Service
public class PublicationService {
    @Autowired
    private IPublicationRepository publicationRepository;


    public Mono<Publication> save(Publication publication){
        validationData(publication);
        return publicationRepository.save(publication);
    }

    private void validationData(Publication publication){
        UtilString.requieresNoNullOrNoEmpty(publication.getPublicationTitle(),String.format(Constant.TXT_EXPECT_VALUE, publication.getPublicationTitle()));
        UtilString.requieresNoNullOrNoEmpty(publication.getCategory().toString(),String.format(Constant.TXT_EXPECT_VALUE, publication.getCategory()));
        UtilString.requieresNoNullOrNoEmpty(publication.getDescription(),String.format(Constant.TXT_EXPECT_VALUE, publication.getDescription()));
        UtilString.requieresNoNullOrNoEmpty(publication.getPhone(),String.format(Constant.TXT_EXPECT_VALUE, publication.getPhone()));

        UtilString.requieresLength(publication.getPhone(), 10, 10,String.format(Constant.TXT_NO_LENGTH_REQUIERED, publication.getPhone()));

    }

}