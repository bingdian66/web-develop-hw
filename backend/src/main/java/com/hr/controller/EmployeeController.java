package com.hr.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.dto.Result;
import com.hr.entity.Employee;
import com.hr.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public Result<Page<Employee>> list(@RequestParam(defaultValue = "1") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(required = false) String keyword) {
        return Result.success(employeeService.list(page, size, keyword));
    }

    @GetMapping("/{id}")
    public Result<Employee> get(@PathVariable Long id) {
        return Result.success(employeeService.get(id));
    }

    @PostMapping
    public Result<Void> add(@RequestBody Employee employee) {
        employeeService.add(employee);
        return Result.success(null);
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        employeeService.update(employee);
        return Result.success(null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return Result.success(null);
    }
}
