# clock-task


原本为了OA项目中的定时发送邮件功能，仿照Spring-Task的定时任务小组件。

在**Spring Boot**中有一个自带的**@Scheduled**注解，可以用于启动定时任务，使用很方便。
但是不能动态修改任务时间，而且默认单线程。参考[江南一点雨]提供的思路，仿照后的组件有一下特性：


- 方便快捷接入
- 支持随时启停任务
- 支持动态参数传递
- 支持动态修改任务时间
- 支持Cron表达式
- 支持日志ID跟踪(未使用数据库做持久化，本身作为单独组件)


## 使用
使用很简单，只要两步即可接入（本项目依赖**Spring Boot**中的**spring-boot-starter-web**组件）。

1. 在pom.xml中引入上面的依赖。
2. 在Spring Boot配置文件中设置如下配置,

```
# application.yml

ant-task:
  conf:
    pool-size: 10
    file-path: /task.properties
```








