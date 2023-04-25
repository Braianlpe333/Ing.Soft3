package com.uco.apisolveit.publication.client;

import com.uco.apisolveit.publication.domain.publication.Publication;
import com.uco.apisolveit.publication.domain.publicationtype.PublicationType;
import com.uco.apisolveit.publication.service.publication.PublicationService;
import com.uco.apisolveit.publication.util.gson.MapperJsonObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public void receiveMessageProcessPerson(String message)  {
        try{

            System.out.println(obtenerObjetoDeMensaje(message).get());
            Publication publication = obtenerObjetoDeMensaje(message).get();
            PublicationType type = new PublicationType();
            type.setDescription("GARDENING");
            type.setId("1243324");
            publication.setId("123");
            publication.setCategory(type);

            System.out.println(publication);

            publicationService.save(publication);

        }catch(Exception e){
           System.out.println(e);
        }
    }

    private Optional<Publication> obtenerObjetoDeMensaje(String mensaje){
        return mapperJsonObject.ejecutar(mensaje, Publication.class);
    }

}
