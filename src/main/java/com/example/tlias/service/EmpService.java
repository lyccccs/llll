package com.example.tlias.service;

import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;


public interface EmpService {

    PageBean page(Integer page, Integer pageSize, String name, Short gender,LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);



    Emp getByid(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
