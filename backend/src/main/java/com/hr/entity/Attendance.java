// Attendance.java
// 考勤记录实体类（对应数据库表 t_attendance）
//
// 字段：
//   - id              主键，自增
//   - employeeId      员工 ID
//   - attendanceDate  考勤日期
//   - status          考勤状态（正常/缺勤/请假/病假）
//   - remark          备注
//   - createTime      创建时间
//   - updateTime      更新时间
//
// 使用 MyBatis-Plus 注解映射，Lombok @Data 生成 getter/setter。
