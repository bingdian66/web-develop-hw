// Admin.java
// 管理员实体类（对应数据库表 t_admin）
//
// 字段：
//   - id          主键，自增
//   - username    用户名
//   - password    密码（BCrypt 加密存储）
//   - createTime  创建时间
//   - updateTime  更新时间
//
// 使用 MyBatis-Plus 注解映射，Lombok @Data 生成 getter/setter。
