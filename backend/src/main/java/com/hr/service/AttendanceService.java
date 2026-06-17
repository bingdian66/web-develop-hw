package com.hr.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.entity.Attendance;
import com.hr.mapper.AttendanceMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceMapper attendanceMapper;

    public void add(Attendance attendance) {
        attendanceMapper.insert(attendance);
    }

    public Page<Attendance> list(int page, int size, Long employeeId, String month) {
        Page<Attendance> p = new Page<>(page, size);
        QueryWrapper<Attendance> qw = new QueryWrapper<>();
        if (employeeId != null) qw.eq("employee_id", employeeId);
        if (month != null) qw.likeRight("attendance_date", month);
        qw.orderByDesc("attendance_date");
        return attendanceMapper.selectPage(p, qw);
    }

    public Map<String, Object> stats(Long employeeId, String month) {
        QueryWrapper<Attendance> qw = new QueryWrapper<>();
        if (employeeId != null) qw.eq("employee_id", employeeId);
        if (month != null) qw.likeRight("attendance_date", month);

        var records = attendanceMapper.selectList(qw);
        long total = records.size();
        long normal = records.stream().filter(r -> "正常".equals(r.getStatus())).count();
        long absent = records.stream().filter(r -> "缺勤".equals(r.getStatus())).count();
        long leave = records.stream().filter(r -> "请假".equals(r.getStatus())).count();
        long sick = records.stream().filter(r -> "病假".equals(r.getStatus())).count();

        Map<String, Object> result = new HashMap<>();
        result.put("total", total);
        result.put("normal", normal);
        result.put("absent", absent);
        result.put("leave", leave);
        result.put("sick", sick);
        result.put("rate", total > 0 ? String.format("%.2f", normal * 100.0 / total) : "0");
        return result;
    }

    public void update(Attendance attendance) {
        attendanceMapper.updateById(attendance);
    }

    public void delete(Long id) {
        attendanceMapper.deleteById(id);
    }
}
