package com.example.demo.RepD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ModD.Modeldetails;

@Repository
public interface RepoD  extends JpaRepository<Modeldetails,Integer>
{

}