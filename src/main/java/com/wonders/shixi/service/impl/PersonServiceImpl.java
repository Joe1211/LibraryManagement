package com.wonders.shixi.service.impl;

import com.wonders.shixi.mapper.PersonMapper;
import com.wonders.shixi.pojo.Person;
import com.wonders.shixi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,timeout=5)
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonMapper personMapper;
    @Override
    public List<Person> postAllPerson() {
       List<Person> persons= personMapper.getPerson();
        return persons;
    }
}
