package com.service;

import com.domain.emp;
import com.mapper.empMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class empService
{
    @Autowired
    private empMapper emp;

    public List<emp> getAll(){
        return emp.GetAll();
    }
}
