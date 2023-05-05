package com.example.demo.Ser;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.ModD.Modeldetails;
import com.example.demo.ModL.ModelLogin;
import com.example.demo.RepD.RepT;
import com.example.demo.RepD.RepoD;
import com.example.demo.RepL.RepoL;

import jakarta.transaction.Transactional;


@Service
public class Ser {
	
	@Autowired
	RepoD repository;
	
	@Autowired
	RepoL repositoryL;
	
	@Autowired
	RepT repositoryT;
	
	
	
	public String addCustomer(Modeldetails customer)
	{
		repository.save(customer);
		return "Added successfully";
	}
	public List<Modeldetails> getCustomer()
	{
		return repository.findAll();
		
	}
	public Optional<Modeldetails> getCustomerById(int id)
	{
		return repository.findById(id);
	}
	public String updateCustomer(Modeldetails customer)
	{
		repository.save(customer);
		return "Updated successfully";
	}
	public String deleteById(int id)
	{
		repository.deleteById(id);
		return "Deleted successfully";
	}
	
	public List<Modeldetails> getProDetails(@RequestParam String field)
	{
		return repository.findAll(Sort.by(Direction.ASC,field));
	}

	public List<Modeldetails> getProwithPag(int offset, int pagesize)
	{
		Page<Modeldetails> page=repository.findAll(PageRequest.of(offset, pagesize));
		return page.getContent();
	}
	
	public String checkLogin(String uname,String pwd)
	{
		ModelLogin user=repositoryL.findByuname(uname);
		if(user==null)
		{
			return "Invalid Details";
		}
		else
		{
			if(user.getPwd().equals(pwd))
			{
				return "Login successful";
			}
			else
			{
				return "Login failed";
			}
		}
	}
	
	public ModelLogin addUser(ModelLogin mod)
	{
		return repositoryL.save(mod);
	}
	
	
	public List<ModelLogin> getUser()
	{
		return repositoryL.findAll();
	}
	
	//delete query
	@Transactional
	public int deleteCustByName(String name)
	{
		return repository.deleteCustByName(name);
	}

	//update query
	@Transactional
	public int updateCust(String city,String mname)
	{
		return repository.updateCust(city, mname);
	}
	
	
	//fetch by name start
    public List<Modeldetails> fetchCustByNamePrefix(String prefix)
	{
		return repository.findByNameStartingWith(prefix);
	}
    
    
    
	//fetch by name end
	public List<Modeldetails> fetchCustByNameSuffix(String suffix)
	{
		  return repository.findByNameEndingWith(suffix);
	}
	
	
	
	
	
	
	//native
	@Transactional
	public List<Modeldetails> fetchCustByWeight(String weight)
	{
		return repository.fetchCustByWeight(weight);
	}
	
	
	//select query1
	public List<Modeldetails> getCustByName(String name,String operation)
	{
		return repository.getCustByName(name, operation);
	}
	
	
	
	//select query2
	public List<Modeldetails> getCustByName(String name)
	{
		return repository.getCustByName(name);
	}

	
	
	


}