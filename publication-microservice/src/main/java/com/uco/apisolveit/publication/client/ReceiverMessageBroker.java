package com.uco.apisolveit.publication.client;

import com.uco.apisolveit.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiverMessageBroker {
    @Autowired
    private PersonService personService;

    public void receiveMessageProcessPerson() throws Exception {
        try{

        }catch(Exception e){
            throw new Exception(e);
        }
    }


}
