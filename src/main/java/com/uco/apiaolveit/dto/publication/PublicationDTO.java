package com.uco.apiaolveit.dto.publication;

public class PublicationDTO {
    private String id;
    private String publicationTitle;
    private String description;
    private String phone;
    private String category;


    public PublicationDTO(String id, String publicationTitle, String description, String phone, String category) {
        setId(id);
        setPublicationTitle(publicationTitle);
        setCategory(category);
        setPhone(phone);
        setDescription(description);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
