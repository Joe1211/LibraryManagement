package com.wonders.shixi.controller;

import com.wonders.shixi.pojo.Person;
import com.wonders.shixi.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "人模块")
public class GetPerson {

    @Autowired
    PersonService personService;

    private static final Logger log= LogManager.getLogger(GetPerson.class.getName());

    @RequestMapping(value="/getPerson.do",method = RequestMethod.GET)
    @ResponseBody

    public Person getPerson(@RequestParam("name") String name){
        log.info(name);
        log.error(name);
      Person person=  new Person();
      person.setName(name);
      return person;

    }
    @RequestMapping(value = "/person",method = RequestMethod.GET)
    public String person(){
        return  "/html/person.html";
    }


    @RequestMapping(value="/postPerson.do",method = RequestMethod.GET)
    @ResponseBody
    public List<Person>     postPerson(@RequestParam("name") String name){
        Person person=  new Person();
        person.setName(name);
        List<Person> persons=personService.postAllPerson();
        persons.add(person);
        return persons;

    }
}
