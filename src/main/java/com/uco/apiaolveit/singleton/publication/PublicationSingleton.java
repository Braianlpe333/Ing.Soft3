package com.uco.apiaolveit.singleton.publication;

import com.uco.apiaolveit.domain.publication.Publication;


public class PublicationSingleton {
    private PublicationSingleton() {
        //Instant the class
    }

    private static class SingletonHelper{
        private static final Publication INSTANCE = new Publication();
    }
    public static Publication getInstance(){
        return PublicationSingleton.SingletonHelper.INSTANCE;
    }
}
