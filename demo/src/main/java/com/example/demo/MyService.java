package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<CustomerEntity> getData() {
		return customerRepository.findAll();
	}
	public CustomerEntity findData(int a) {
		return customerRepository.findById(a).orElse(null);
	}
	public CustomerEntity modData(CustomerEntity cust,int id) {
		CustomerEntity set = customerRepository.findById(id).orElse(null);
		set.setAddress(cust.getAddress());
		set.setName(cust.getName());
		return customerRepository.save(set);		
	}
	public CustomerEntity addData(CustomerEntity cust) {
		return customerRepository.save(cust);		
	}
	public String deleteData(Integer id) {
		customerRepository.deleteById(id);
		return "Deleted Succesfully";
	}
}
