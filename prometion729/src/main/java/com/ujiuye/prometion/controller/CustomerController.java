package com.ujiuye.prometion.controller;

import com.ujiuye.prometion.pojo.Customer;
import com.ujiuye.prometion.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/listAll")
    public List<Customer> listAll(){
        List<Customer> list=customerService.list();
        return list;
    }
}
