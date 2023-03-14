package com.uco.apiaolveit.service.person;

import com.uco.apiaolveit.domain.person.Person;
import com.uco.apiaolveit.util.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.uco.apiaolveit.repository.person.IPersonRepository;
import com.uco.apiaolveit.util.Constant;

import java.util.Objects;


@Service
public class PersonService {
   @Autowired
    private IPersonRepository personrepository;

    public Mono<Person> get(String email){
         if(!Objects.isNull(email)){
             UtilString.requiresPattern(email, Constant.TXT_PATTER_EMAIL,String.format(Constant.TXT_BAD_EMAIL));
         }

        return personrepository.findByEmail(email);
    }
    public Mono<Person> save(Person person){
        validationData(person);
        return personrepository.save(person);
    }

    public Mono<Person>  patch(String email,Person person){
        validationData(person);

        return personrepository.findByEmail(email).flatMap(existingPerson -> {

            existingPerson.setName(person.getName().isEmpty() ? existingPerson.getName() : person.getName());
            existingPerson.setSurname(person.getSurname().isEmpty() ? existingPerson.getSurname() : person.getSurname());
            existingPerson.setEmail(person.getEmail().isEmpty() ? existingPerson.getEmail() : person.getEmail());
            existingPerson.setPhone(Objects.isNull(person.getPhone()) ? existingPerson.getPhone() : person.getPhone());
            existingPerson.setPassword(person.getPassword().isEmpty() ? existingPerson.getPassword() : person.getPassword());
            existingPerson.setPassword(person.getEmploymentField().isEmpty() ? existingPerson.getEmploymentField() : person.getEmploymentField());

            return personrepository.save(existingPerson);
        });
    }

    public Mono<Void> delete(String mail){
        return personrepository.findById(mail).flatMap(existingPerson -> personrepository.deleteById(mail));
    }


    private void validationData(Person person){
        UtilString.requieresNoNullOrNoEmpty(person.getName(),String.format(Constant.TXT_EXPECT_VALUE, person.getName()));
        UtilString.requieresNoNullOrNoEmpty(person.getEmail(),String.format(Constant.TXT_EXPECT_VALUE, person.getEmail()));
        UtilString.requieresNoNullOrNoEmpty(person.getPassword(),String.format(Constant.TXT_EXPECT_VALUE, person.getPassword()));
        UtilString.requieresNoNullOrNoEmpty(person.getPhone(),String.format(Constant.TXT_EXPECT_VALUE, person.getPhone()));
        UtilString.requieresNoNullOrNoEmpty(person.getEmploymentField(),String.format(Constant.TXT_EXPECT_VALUE, person.getEmploymentField()));
        UtilString.requieresNoNullOrNoEmpty(person.getSurname(),String.format(Constant.TXT_EXPECT_VALUE, person.getSurname()));


        UtilString.requiresPattern(person.getEmail(), Constant.TXT_PATTER_EMAIL,String.format(Constant.TXT_BAD_EMAIL));


        UtilString.requieresLength(person.getPassword(),10,10,String.format(Constant.TXT_NO_LENGTH_REQUIERED, person.getPassword()));
        UtilString.requieresLength(person.getPhone(), 10, 10,String.format(Constant.TXT_NO_LENGTH_REQUIERED, person.getPhone()));

    }
}
