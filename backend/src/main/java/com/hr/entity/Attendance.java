package com.hr.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("t_attendance")
public class Attendance {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long employeeId;
    private LocalDate attendanceDate;
    private String status;
    private String remark;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
