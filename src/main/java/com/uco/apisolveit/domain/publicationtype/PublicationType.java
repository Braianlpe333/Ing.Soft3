package com.uco.apisolveit.domain.publicationtype;


import com.uco.apisolveit.dto.publicationtype.PublicationTypeDTO;
import com.uco.apisolveit.singleton.publication.PublicationSingleton;
import com.uco.apisolveit.singleton.publicationtype.PublicationTypeSingleton;
import com.uco.apisolveit.util.exception.GeneralException;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "publicationType_data")
public class PublicationType {

    @Id
    private String id;
    private String description;

    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getDescription(){return description.toString();}

    public void setDescription(String id){
        switch (id){
            case("6423292d6009b28ddb30b941"):{
                this.description = PublicationTypeEnum.GARDENING.toString();
                break;
            }
            case ("64232b986009b28ddb30b944"):{
                this.description = PublicationTypeEnum.ASSISTANCE.toString();
                break;
            }
            case ("64232b836009b28ddb30b943"):{
                this.description = PublicationTypeEnum.TECHNOLOGY.toString();
                break;
            }
            default:{
                throw GeneralException.build("The category is not valid");
            }
        }
    }

    @Override
    public String toString(){
        return "PublicationType{"+
                "id='" + id + '\''+
                ", description='"+ description + '\''+
                '}';
    }

    /*public static PublicationType setData(PublicationTypeDTO publicationTypeDTO) {
        PublicationType publicationType = PublicationTypeSingleton.getInstance();
        publicationType.setId(publicationTypeDTO.getId());
        publicationType.setId(publicationTypeDTO.getDescription());
        return publicationType;
    }*/
}


