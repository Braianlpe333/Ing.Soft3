package com.uco.apisolveit.publication.singleton.publication;

import com.uco.apisolveit.publication.domain.publication.Publication;


public class PublicationSingleton {
    private PublicationSingleton() {
        //Instant the class
    }

    private static class SingletonHelper{
        private static final Publication INSTANCE = new Publication();
    }
    public static Publication getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
