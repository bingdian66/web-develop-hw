// AuthController.java
// 认证管理控制器
//
// 提供登录认证相关的 REST API（路径前缀 /api/auth）：
//   - POST /api/auth/register  管理员注册（用户名 + 密码）
//   - POST /api/auth/login     管理员登录，成功后写入 HttpSession
//   - POST /api/auth/logout    退出登录，使 Session 失效
//   - GET  /api/auth/current   获取当前登录的管理员信息
//
// 返回前会清空密码字段，依赖 AuthService 实现具体逻辑。
