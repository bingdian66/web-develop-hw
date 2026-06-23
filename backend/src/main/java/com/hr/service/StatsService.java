// StatsService.java
// 统计报表业务逻辑层
//
// 负责各类统计数据的聚合计算：
//   - overview()          总览统计：员工总数、部门总数
//   - departmentStats()   各部门人数统计（部门名 -> 人数）
//   - hireStats()         入职统计：本月入职、本年入职人数
//   - attendanceStats()   考勤统计：总记录数、正常出勤数、出勤率
//
// 依赖 EmployeeMapper、DepartmentMapper、AttendanceMapper 查询数据。
