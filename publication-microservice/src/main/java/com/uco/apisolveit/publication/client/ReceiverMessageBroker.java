package com.uco.apisolveit.publication.client;

import com.mongodb.MongoException;
import com.uco.apisolveit.publication.domain.publication.Publication;
import com.uco.apisolveit.publication.domain.publicationtype.PublicationType;
import com.uco.apisolveit.publication.dto.publication.PublicationDTO;
import com.uco.apisolveit.publication.service.publication.PublicationService;
import com.uco.apisolveit.publication.util.gson.MapperJsonObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class ReceiverMessageBroker {
    @Autowired
    private PublicationService publicationService;

    private final MapperJsonObject mapperJsonObject;

    public ReceiverMessageBroker(MapperJsonObject mapperJsonObject) {
        this.mapperJsonObject = mapperJsonObject;
    }

    @RabbitListener(queues = "${client.queue-recibir.cliente.queue-name}")
    public Mono<Publication> receiveMessageProcessPerson(String message)  {
        PublicationDTO dto = obtenerObjetoDeMensaje(message).get();
        try{
            return publicationService.save(Publication.setData(dto));
        }catch(MongoException e){
           throw e;
        }
    }

    private Optional<PublicationDTO> obtenerObjetoDeMensaje(String mensaje){
        return mapperJsonObject.ejecutar(mensaje, PublicationDTO.class);
    }

}
