package com.table.Table.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.table.Table.entity.CustomerEntity;
import com.table.Table.entity.FormEntity;
import com.table.Table.entity.MergeTable;
import com.table.Table.repo.Repo1;
import com.table.Table.repo.Repo2;
import com.table.Table.repo.Repo3;

@Component
public class ServiceImp 
{

	@Autowired
	Repo1 repo1;
	
	@Autowired
	Repo2 repo2;
	
	@Autowired
	Repo3 repo3;
	
	public CustomerEntity createCustomer(CustomerEntity ce) {
		return repo1.save(ce);
	}
	
	public FormEntity formCustomer(FormEntity fe) {
		return repo2.save(fe);
	}
	
	public CustomerEntity UpdateCustomer(CustomerEntity ce) {
		Optional<CustomerEntity> byId = repo1.findById(ce.getRollNo());
		CustomerEntity updateCustomer = byId.get();
		updateCustomer.setName(ce.getName());
		return repo1.save(updateCustomer);
		
	}
	
	public void deleteCustomer(int rollNo) 
	{
		repo1.deleteById(rollNo);
	}
	
    public List<CustomerEntity> allCustomer() {
		return repo1.findAll();
	}
	
	
	
	public void mergeTables() 
	{
		List<CustomerEntity> clg = repo1.findAll();
		List<FormEntity> form = repo2.findAll();

		List<MergeTable> mergeDataList=new ArrayList<>();
		
		for (CustomerEntity colleges : clg) 
		{
			MergeTable mergeTable =new  MergeTable();
			
			mergeTable.setRollNo(colleges.getRollNo());
			mergeTable.setName(colleges.getName());
			mergeTable.setPhoneNo(colleges.getPhoneNo());
			mergeTable.setAge(colleges.getAge());
			
			
			for (FormEntity fr : form) 
			{
                if (fr.getRollNo()==colleges.getRollNo()) 
                {
                    mergeTable.setFirstName(fr.getFirstName());
                    mergeTable.setLastName(fr.getLastName());
                    mergeTable.setEmail(fr.getEmail());
                    break;
                }
		    }
			mergeDataList.add(mergeTable);
			
	    }
		repo3.saveAll(mergeDataList);
	}
}
