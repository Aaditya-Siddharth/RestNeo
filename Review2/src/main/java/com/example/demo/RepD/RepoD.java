package com.example.demo.RepD;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.ModD.Modeldetails;

import jakarta.transaction.Transactional;

@Repository
public interface RepoD  extends JpaRepository<Modeldetails,Integer>
{
	
	//delete
	@Modifying
	@Query("delete from Modeldetails s where s.name=?1")
	public int deleteCustByName(String name);
	
	//update
		@Modifying
		@Transactional
		@Query("update Modeldetails s set s.cusine=?1 where s.name=?2 ")
		public int updateCust(String cusine,String name);
		
	//native
		@Query(value="select*from details s where s.price=?1",nativeQuery=true)
		public List<Modeldetails>fetchCustByWeight(String price);
		
	//select query1
		@Query("select s from Modeldetails s where s.name=?1 and s.meal=?2")
		public List<Modeldetails> getCustByName(String name,String meal);

	//select query2
		@Query("select s from Modeldetails s where s.name=:name")
		public List<Modeldetails> getCustByName(String name);
		
		List<Modeldetails> findByNameStartingWith(String prefix);
		List<Modeldetails> findByNameEndingWith(String suffix);
		
		
}