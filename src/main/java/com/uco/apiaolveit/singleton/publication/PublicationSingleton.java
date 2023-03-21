package com.uco.apiaolveit.singleton.publication;

import com.uco.apiaolveit.domain.person.Person;
import com.uco.apiaolveit.domain.publication.Publication;
import com.uco.apiaolveit.singleton.person.PersonSingleton;

public class PublicationSingleton {
    public PublicationSingleton() {
        //Instant the class
    }

    private static class SingletonHelper{
        private static final Publication INSTANCE = new Publication();
    }
    public static Publication getInstance(){
        return PublicationSingleton.SingletonHelper.INSTANCE;
    }
}
