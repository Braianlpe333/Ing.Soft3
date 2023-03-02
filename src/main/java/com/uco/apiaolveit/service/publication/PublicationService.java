package com.uco.apiaolveit.service.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

}
