package com.uco.apiaolveit.domain.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;


@Document(collection = "person_data")
public class Person {

    @Id
    private String id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String employmentField;

    public Person(){
    }

    public String getId(){return id;}

    public void setId(String name){this.id = id;}
    public String getName(){return name;}

    public void setName(String name){this.name = name;}
    public String getSurname(){return surname;}

    public void setSurname(String surname){this.surname = surname;}
    public String getEmail(){return email;}

    public void setEmail(String email){this.email = email;}
    public String getPassword(){return password;}

    public void setPassword(String password){this.password = password;}
    public String getPhone(){return phone;}

    public void setPhone(String phone){this.phone = phone;}
    public String getEmploymentField(){return employmentField;}

    public void setEmploymentField(String employmentField){this.employmentField = employmentField;}

    @Override
    public String toString(){
        return "Person{"+
                "id='" + id + '\''+
                ", name='"+ name + '\''+
                ", surname='"+ surname + '\''+
                ", email='"+ email + '\''+
                ", password='"+ password + '\''+
                ", phone='"+ phone + '\''+
                ", employmentField'"+ employmentField + '\''+
                '}';
    }
}
