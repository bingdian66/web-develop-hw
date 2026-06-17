package com.hr.service;

import com.hr.entity.Department;
import com.hr.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentMapper departmentMapper;

    public List<Department> list() {
        return departmentMapper.selectList(null);
    }

    public Department get(Long id) {
        return departmentMapper.selectById(id);
    }

    public void add(Department dept) {
        departmentMapper.insert(dept);
    }

    public void update(Department dept) {
        departmentMapper.updateById(dept);
    }
}
