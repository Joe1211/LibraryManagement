package com.wonders.shixi.controller;

import com.wonders.shixi.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetPerson {
    @RequestMapping(value="/getPerson.do",method = RequestMethod.GET)
    @ResponseBody
    public Person getPerson(@RequestParam("name") String name){
      Person person=  new Person();
      person.setName(name);
      return person;

    }
    @RequestMapping(value = "/person",method = RequestMethod.GET)
    public String person(){
        return  "/html/person.html";
    }
}
