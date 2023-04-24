package com.uco.apisolveit.messengerservice.client;

import com.uco.apisolveit.domain.person.Person;
import com.uco.apisolveit.service.person.PersonService;
import com.uco.apisolveit.util.gson.MapperJsonObject;
import org.apache.catalina.mapper.Mapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReceiverMessageBroker {
    @Autowired
    private PersonService personService;

    private final MapperJsonObject mapperJsonObject;

    public ReceiverMessageBroker(MapperJsonObject mapperJsonObject) {
        this.mapperJsonObject = mapperJsonObject;
    }

    @RabbitListener(queues = "${client.queue-recibir.cliente.queue-name}")
    public void receiveMessageProcessPerson(String message)  {
        try{
            personService.save(obtenerObjetoDeMensaje(message).get());
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private Optional<Person> obtenerObjetoDeMensaje(String mensaje){
        return mapperJsonObject.ejecutar(mensaje, Person.class);
    }

}
