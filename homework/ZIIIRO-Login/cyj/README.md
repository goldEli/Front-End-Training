ZIIIRO登录界面Demo
====
Demo使用技术栈
----
    前端：HTML CSS 
    数据交换：Ajax
    后端：Springboot Mybatis 
    数据库：Mysql
如何启动项目
---
    项目工程在login文件夹下，静态页面文件夹内存放ZIIIRO静态页面。
    IDEA打开login文件夹内工程，下载好依赖，直接启动即可
    默认访问路径:localhost：8080/login
    完成注册后页面不跳转,登录成功后页面跳转到：localhost:8080/login/inter
Tips
---
    由于没有写拦截器，因此可以直接访问登录成功后的页面。
    前端校验失败全部由前端页面展示，后端校验失败由弹窗显示。
