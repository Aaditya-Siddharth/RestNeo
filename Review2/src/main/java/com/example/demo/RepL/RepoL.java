package com.example.demo.RepL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ModL.ModelLogin;

@Repository
public interface RepoL extends JpaRepository<ModelLogin,String> 
{
    ModelLogin findByuname(String uname);
}