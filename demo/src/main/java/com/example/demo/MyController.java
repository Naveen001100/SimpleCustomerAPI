package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

	@Autowired
	MyService myService;
	
	@GetMapping("/")
	public List<CustomerEntity> getData() {
		return myService.getData();
	}
	
	@GetMapping("/customer/{Id}")
	public CustomerEntity findData(@PathVariable String Id) {
		return myService.findData(Integer.parseInt(Id));
	}
	
	@PostMapping("/addCustomer")
	public CustomerEntity addData(@RequestBody CustomerEntity cust) {
		return myService.addData(cust);
	}
	
	@PutMapping("/modCustomer/{Id}")
	public CustomerEntity addData(@RequestBody CustomerEntity cust,@PathVariable String Id) {
		return myService.modData(cust,Integer.parseInt(Id));
	}
	
	@DeleteMapping("/customer/{Id}")
	public String deleteData(@PathVariable String Id) {
		return myService.deleteData(Integer.parseInt(Id));
	}

}


