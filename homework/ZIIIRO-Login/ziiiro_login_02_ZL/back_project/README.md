### 项目名

ziiiro首页登录注册功能代码实现

### 项目业务需求

1. 登录功能实现，主要包含三个部分的逻辑：

- 前端验证：密码合法性验证 + 用户和密码输入框非空验证
- 后端验证：用户名是否注册验证 + 密码是否正确验证
- 其他工作：remember me 将用户名和密码以键值对的方式存在local storage中，同时对密码进行MD5加密

2. 注册功能实现，主要分为两个部分的逻辑：

- 前端验证：注册邮箱、密码的合法性验证 + 输入框非空验证
- 后端验证：邮箱是否注册验证 + 密码是否正确验证

### 使用技术

* 前端：react
* 后端：SpringBoot + Spring Data JPA

### 项目启动方式

1. 将代码下载到本地
2. 修改application.yml文件中的datasource信息，在本地mysql数据库新建user表：

```sql
 CREATE TABLE `user` (
  `id` varchar(100) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

3. 打开`cmd`命令行，进入到项目路径下，执行maven命令进行打包

```shell
mvn clean package
```

4. cd 到项目路径下的target目录下，执行命令启动项目

```dos
java -jar ziiiro_login-1.0-SNAPSHOT.jar
```

5. 浏览器输入 http://IP:8081地址进行页面进行测试

