package com.uco.apisolveit.publication.singleton.publicationtype;


import com.uco.apisolveit.publication.domain.publicationtype.PublicationType;

public class PublicationTypeSingleton {
    private PublicationTypeSingleton() {
        //Instant the class
    }

    private static class SingletonHelper{
        private static final PublicationType INSTANCE = new PublicationType();
    }
    public static PublicationType getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
