package com.chloe.curd.crud.controller;

import com.chloe.curd.crud.entity.Dept;
import com.chloe.curd.crud.service.DeptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author lfy
 * @Description
 * @create 2023-04-28 16:41
 */
@Tag(name = "部门", description = "部门信息接口文档")
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @Operation(description = "获取数据",summary = "获取")
    @GetMapping("/dept/{id}")
    public Dept getDept( @PathVariable("id") Long id){
        return deptService.getDeptById(id);
    }

    @GetMapping("/depts")
    public List<Dept> getDept(){
        return deptService.getDepts();
    }

    @PostMapping("/dept")
    public String saveDept(@RequestBody Dept dept){
        deptService.saveDept(dept);
        return "ok";
    }
    @DeleteMapping("/dept/{id}")
    public String deleteDept( @PathVariable("id") Long id){
        deptService.deleteDept(id);
        return "ok";
    }
}
