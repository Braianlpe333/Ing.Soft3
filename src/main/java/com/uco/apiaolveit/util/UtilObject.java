package com.uco.apiaolveit.util;

public class UtilObject {
    private static UtilObject instance = new UtilObject();

    private UtilObject() {

    }

    public static UtilObject getUtilObject() {
        return instance;
    }
    public <T> boolean isNull(T object) {
        return object== null;
    }
    public <T> T getDefault(T object, T defaultValue) {
        return isNull(object) ? defaultValue : object ;
    }
}
