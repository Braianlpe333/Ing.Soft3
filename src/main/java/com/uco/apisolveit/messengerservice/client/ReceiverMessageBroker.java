package com.uco.apisolveit.messengerservice.client;

import com.uco.apisolveit.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiverMessageBroker {
    @Autowired
    private PersonService personService;

    public void receiveMessageProcessPerson(String message){
        try{

        }catch(Exception e){
            System.out.println(e);
        }
    }


}
