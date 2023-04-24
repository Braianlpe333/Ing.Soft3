package com.uco.apisolveit.publication.domain.publicationtype;

import com.uco.apisolveit.publication.singleton.publicationtype.PublicationTypeSingleton;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "publicationType_data")
public class PublicationType {

    @Id
    private String id;
    private String description;

    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getDescription(){return description;}

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return "PublicationType{"+
                "id='" + id + '\''+
                ", description='"+ description + '\''+
                '}';
    }

    public static PublicationType setData( String description){
        PublicationType type = PublicationTypeSingleton.getInstance();
        switch (description){
            case ("GARDENING"):{

                type.setDescription(description);
                break;
            }
            case("TECHNOLOGY"):{
                type.setDescription(description);
                break;
            }
            case("ASSISTANCE"):{
                type.setDescription(description);
                break;
            }
            default: {
                type.setId(null);
                type.setDescription(null);
                break;
            }
        }
        return type;
    }
}


