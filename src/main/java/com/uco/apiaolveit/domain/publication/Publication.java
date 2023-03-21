package com.uco.apiaolveit.domain.publication;

import com.uco.apiaolveit.domain.person.Person;
import com.uco.apiaolveit.dto.person.PersonDTO;
import com.uco.apiaolveit.dto.publication.PublicationDTO;
import com.uco.apiaolveit.singleton.person.PersonSingleton;
import com.uco.apiaolveit.singleton.publication.PublicationSingleton;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "publication_data")
public class Publication {

    @Id
    private String id;
    private String publicationTitle;
    private String description;
    private String phone;
    private String category;

    public Publication(){
        this.id = " ";
        this.publicationTitle = " ";
        this.description= " ";
        this.phone=" ";
        this.category = " ";
    }

    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getPublicationTitle(){return publicationTitle;}

    public void setPublicationTitle(String publicationTitle){this.publicationTitle = publicationTitle;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public String getCategory(){return category;}

    public void setCategory(String category){this.category = category;}

    public String getPhone(){return phone;}

    public void setPhone(String phone){this.phone = phone;}

    @Override
    public String toString(){
        return "Publication{"+
                "id='" + id + '\''+
                ", publicationTitle='"+ publicationTitle + '\''+
                ", description='"+ description + '\''+
                ", phone='"+ phone + '\''+
                ", category='"+ category + '\''+
                '}';
    }
    public static Publication setData(PublicationDTO publicationDTO){
        Publication publication = PublicationSingleton.getInstance();
        publication.setId(publicationDTO.getId());
        publication.setPublicationTitle(publicationDTO.getPublicationTitle());
        publication.setPhone(publicationDTO.getPhone());
        publication.setCategory(publicationDTO.getCategory());
        publication.setDescription(publicationDTO.getDescription());
        return publication;
    }

}
