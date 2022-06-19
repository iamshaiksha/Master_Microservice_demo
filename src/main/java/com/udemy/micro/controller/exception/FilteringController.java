package com.udemy.micro.controller.exception;

import com.udemy.micro.model.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
    @GetMapping(value="/filtering")
    public  SomeBean getfeilds()
    {
       return new SomeBean("field1","field2","field3");
    }
}
