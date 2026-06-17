package com.hr.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.entity.Employee;
import com.hr.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeMapper employeeMapper;

    public Page<Employee> list(int page, int size, String keyword) {
        Page<Employee> p = new Page<>(page, size);
        QueryWrapper<Employee> qw = new QueryWrapper<>();
        if (keyword != null && !keyword.isEmpty()) {
            qw.like("name", keyword).or().like("employee_no", keyword);
        }
        return employeeMapper.selectPage(p, qw);
    }

    public Employee get(Long id) {
        return employeeMapper.selectById(id);
    }

    public void add(Employee employee) {
        employeeMapper.insert(employee);
    }

    public void update(Employee employee) {
        employeeMapper.updateById(employee);
    }

    public void delete(Long id) {
        employeeMapper.deleteById(id);
    }
}
