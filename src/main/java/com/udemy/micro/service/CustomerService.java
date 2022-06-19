package com.udemy.micro.service;

import com.udemy.micro.controller.exception.UserNotFoundException;
import com.udemy.micro.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class CustomerService {

    private static List<Customer> customers=new ArrayList<>();
    private static  int userCount=3;
    static
    {
       customers.add(new Customer(1,"adam",new Date()));
        customers.add(new Customer(2,"Eve",new Date()));
        customers.add(new Customer(3,"jack",new Date()));
    }

    public List<Customer> findall()
    {
       return customers;
    }


    public Customer save(Customer customer)
    {
        if(customer.getId() == 0 )
        {
            customer.setId(++userCount);
        }
        customers.add(customer);
        return customer;
    }


     public Customer findOne(int id)
     {
          for(Customer customer:customers)
          {
              if(customer.getId()==id)
              {
                  return customer;
              }
              throw new UserNotFoundException("UserNotFoundException");
          }
          return null;
     }

     public Customer deleteById(int id)
     {
         Iterator itr=customers.listIterator();
         while (itr.hasNext())
         {
             Customer customer= (Customer) itr.next();
             if(customer.getId()==id) {
                 itr.remove();
                 return customer;
             }

         }
         return null;
     }


}
