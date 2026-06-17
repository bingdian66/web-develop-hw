package com.hr.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("t_employee")
public class Employee {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String employeeNo;
    private String name;
    private Long departmentId;
    private String position;
    private LocalDate hireDate;
    private String phone;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    @TableLogic
    private Integer deleted;
}
