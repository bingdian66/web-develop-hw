// AuthService.java
// 认证业务逻辑层
//
// 负责管理员登录认证相关处理：
//   - register(username, password)         注册新管理员，校验用户名唯一性，密码 BCrypt 加密
//   - login(username, password, session)   登录校验，成功后将 adminId 存入 Session
//   - logout(session)                      退出登录，使 Session 失效
//   - current(session)                     获取当前登录管理员，未登录则抛异常
//
// 依赖 AdminMapper 操作数据库，使用 BCryptPasswordEncoder 处理密码加密与校验。
