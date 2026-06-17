package com.hr.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("t_department")
public class Department {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String deptCode;
    private String deptName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
