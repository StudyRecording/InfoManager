# InfoManager
**Servlet和jsp学习后利用项目复习实践知识。**

# 设计数据库
用户id、用户名、用户密码、用户性别、用户年龄、用户出生日期。

设计一张用户表，其表结构如下：
```sql
CREATE TABLE `t_user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `sex` char(2) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```

# 实现功能
1. 用户登录
2. 用户退出
3. 用户信息查询
4. 所有用户信息查询
5. 修改该登录用户密码
6. 新用户注册
7. 利用log4j记录日志
# 开发环境
1. jdk11
2. Tomcat 9
3. eclipse
4. MySQL8

