package com.table.Table.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.table.Table.entity.CustomerEntity;
import com.table.Table.entity.FormEntity;
import com.table.Table.entity.MergeTable;
import com.table.Table.serviceImp.ServiceImp;

@RestController
public class Controller {

	@Autowired
	ServiceImp s;
	
	@PostMapping("/customer/i-noble")
	public CustomerEntity createCustomerPost(@RequestBody CustomerEntity ce) {
		return s.createCustomer(ce);
	}
	
	@PostMapping("/form/i-noble")
	public FormEntity createformPost(@RequestBody FormEntity fe) {
		return s.formCustomer(fe);
	}
	
	/*@PostMapping("/merge")
	private void CreateMerge(@RequestBody  mt) 
	return s.mergeTables();
	{
	}*/
	
	@PutMapping("/update")
	public CustomerEntity update(@RequestBody CustomerEntity ce) 
	{
    	return s.UpdateCustomer(ce);
	}
	
	@DeleteMapping("/delete/{rollNo}")
	public void deleteTable(@PathVariable int rollNo) {
		s.deleteCustomer(rollNo);
	}
	
	@GetMapping("/all")
	public List<CustomerEntity> getCustomer() {
	  return s.allCustomer();
	}
	
	
}
