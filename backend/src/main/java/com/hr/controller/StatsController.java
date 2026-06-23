// StatsController.java
// 统计报表控制器
//
// 提供各类统计数据的 REST API（路径前缀 /api/stats）：
//   - GET /api/stats/overview    总览统计（员工总数、部门总数）
//   - GET /api/stats/department  各部门人数统计
//   - GET /api/stats/hire        入职统计（本月/本年入职人数）
//   - GET /api/stats/attendance  考勤统计（总记录数、正常数、出勤率）
//
// 依赖 StatsService 实现聚合统计逻辑。
