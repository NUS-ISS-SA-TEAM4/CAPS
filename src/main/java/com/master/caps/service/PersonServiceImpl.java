package com.master.caps.Service;

import com.master.caps.Model.Person;
import com.master.caps.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements com.master.caps.service.PersonService {

    @Autowired
    private PersonRepository personRepo;

    @Override
    public boolean login(int roleType, String username, String password) {
       Person person = personRepo.findPersonByNameAndPwd(roleType, username, password);

       if(person == null) {
           return false;
       }
        return true;
    }
}
