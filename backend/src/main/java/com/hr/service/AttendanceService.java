// AttendanceService.java
// 考勤管理业务逻辑层
//
// 负责考勤记录的核心业务处理：
//   - add(attendance)                       新增考勤记录
//   - list(page, size, employeeId, month)   分页查询，支持按员工 ID、月份筛选，按日期倒序
//   - stats(employeeId, month)              统计正常/缺勤/请假/病假数量及出勤率
//   - update(attendance)                    按 ID 更新考勤记录
//   - delete(id)                            按 ID 删除考勤记录
//
// 依赖 AttendanceMapper 操作数据库。
