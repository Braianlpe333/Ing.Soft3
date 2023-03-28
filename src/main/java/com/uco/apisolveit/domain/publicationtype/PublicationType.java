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
    private PublicationTypeEnum description;

    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getDescription(){return description.toString();}

    public void setDescription(String id){
        switch (id){
            case("0"):{
                this.description = PublicationTypeEnum.GARDENING;
                break;
            }
            case ("1"):{
                this.description = PublicationTypeEnum.ASSISTANCE;
                break;
            }
            case ("2"):{
                this.description = PublicationTypeEnum.TECHNOLOGY;
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


