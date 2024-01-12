package com.example.tlias.controller;

import com.example.tlias.pojo.Dept;
import com.example.tlias.pojo.Result;
import com.example.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @GetMapping
    public Result list(){
       log.info("查询全部部门数据");
       List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("根据id删除部门：{}",id);
        deptService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }
    @PutMapping
    public Result change(@RequestBody Dept dept){
        log.info("更新部门信息：{}",dept);
        deptService.change(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result search(@PathVariable Integer id){
        log.info("根据id查询部门：{}",id);
        Dept dept = deptService.search(id);
        return  Result.success(dept);

    }
}
