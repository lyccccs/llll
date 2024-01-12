package com.example.tlias.controller;

import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.Result;
import com.example.tlias.service.EmpService;
import com.example.tlias.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class loginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result Login(@RequestBody Emp emp){
        log.info("log in :{}",emp);
       Emp e = empService.login(emp);

       if(e != null){
           Map<String, Object> claims = new HashMap<>();
           claims.put("id", e.getId());
           claims.put("name", e.getName());
           claims.put("username", e.getUsername());
          String jwt = JwtUtils.generateJwt(claims);
          return Result.success(jwt);
       }
       return Result.error("用户名或者密码错误");
    }
}
