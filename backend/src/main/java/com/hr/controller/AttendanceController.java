package com.hr.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.dto.Result;
import com.hr.entity.Attendance;
import com.hr.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping
    public Result<Void> add(@RequestBody Attendance attendance) {
        attendanceService.add(attendance);
        return Result.success(null);
    }

    @GetMapping
    public Result<Page<Attendance>> list(@RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                          @RequestParam(required = false) Long employeeId,
                                          @RequestParam(required = false) String month) {
        return Result.success(attendanceService.list(page, size, employeeId, month));
    }

    @GetMapping("/stats")
    public Result<Map<String, Object>> stats(@RequestParam(required = false) Long employeeId,
                                              @RequestParam(required = false) String month) {
        return Result.success(attendanceService.stats(employeeId, month));
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable Long id, @RequestBody Attendance attendance) {
        attendance.setId(id);
        attendanceService.update(attendance);
        return Result.success(null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        attendanceService.delete(id);
        return Result.success(null);
    }
}
