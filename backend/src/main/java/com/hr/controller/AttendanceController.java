// AttendanceController.java
// 考勤管理控制器
//
// 提供考勤相关的 REST API（路径前缀 /api/attendance）：
//   - POST   /api/attendance        新增考勤记录
//   - GET    /api/attendance        分页查询考勤列表（可按员工、月份筛选）
//   - GET    /api/attendance/stats  查询考勤统计数据（正常/缺勤/请假/病假/出勤率）
//   - PUT    /api/attendance/{id}   更新指定考勤记录
//   - DELETE /api/attendance/{id}   删除指定考勤记录
//
// 依赖 AttendanceService 实现业务逻辑，统一返回 Result 包装结果。
