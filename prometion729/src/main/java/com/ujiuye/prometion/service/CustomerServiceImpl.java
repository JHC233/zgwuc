package com.ujiuye.prometion.service;

import com.ujiuye.prometion.mapper.CustomerMapper;
import com.ujiuye.prometion.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<Customer> list() {
        return customerMapper.list();
    }
}
