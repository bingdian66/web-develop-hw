package com.hr.controller;

import com.hr.dto.Result;
import com.hr.entity.Department;
import com.hr.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public Result<List<Department>> list() {
        return Result.success(departmentService.list());
    }

    @GetMapping("/{id}")
    public Result<Department> get(@PathVariable Long id) {
        return Result.success(departmentService.get(id));
    }

    @PostMapping
    public Result<Void> add(@RequestBody Department dept) {
        departmentService.add(dept);
        return Result.success(null);
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable Long id, @RequestBody Department dept) {
        dept.setId(id);
        departmentService.update(dept);
        return Result.success(null);
    }
}
