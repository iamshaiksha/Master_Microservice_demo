package com.udemy.micro.controller;

import com.udemy.micro.controller.exception.CustomerNotFoundException;
import com.udemy.micro.model.Customer;
import com.udemy.micro.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.reactive.WebFluxLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping(value="/customers")
    public List<Customer> retriveAllcustomer(){
        return customerService.findall();
    }

    @GetMapping(value="/customer/{id}")
    public EntityModel<Customer> retriveCustomer(@PathVariable  int id){

        Customer customer= customerService.findOne(id);
        if(customer==null) {
            throw new CustomerNotFoundException("id-" + id);
        }
            EntityModel<Customer> model=EntityModel.of(customer);
            WebMvcLinkBuilder linkToCUstomers=WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).retriveAllcustomer());
            model.add(linkToCUstomers.withRel("all-customers"));
            return model;
    }

    @PostMapping(value="/SaveCustomer")
    public Customer create(@Valid @RequestBody Customer customer)
    {
        return customerService.save(customer);
    }

    @DeleteMapping(value="/deletecustomer/{id}")
    public void DeleteCustomer(@PathVariable  int id){
        Customer customer=customerService.deleteById(id);
        if(customer==null) {
            throw new CustomerNotFoundException("Customer not found"+ id);
        }
    }

}
