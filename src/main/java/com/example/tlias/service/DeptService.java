package com.example.tlias.service;

import com.example.tlias.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {
    List<Dept> list();

    void delete(Integer id) throws Exception;

    void add(Dept dept);

    Dept search(Integer id);

    void change(Dept dept);
}
