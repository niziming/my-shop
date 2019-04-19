---
title: Spring的一个项目my-shop
catalog: true
date: 2019-04-14 21:40:18
subtitle:
header-img:
tags: [Spring, ]
---

# 概述

- 开发工具,IDEA
- 项目构建方式,Maven
- 基础架构: 三层架构+MVC
- 前端框架: BootStrap+JQuary
- Spring框架
- JUnit测试框架
- log4j 日志框架
- AdminLTE 模板开发

my-shop

## 后台系统
步骤
- 创建一个名字叫my-shop文件夹
- IDEA Open 后创建 pom.xml
- 完善pom.xml
- 完善maven的目录结构
- 完善框架结构
    -src/main/java
        - cn.ziming.my.shop
            - dao
            - service
            - web
- 配置Spring和Log4j
- 导入AdminLTE下的到assets中作为前端资源
    - bower_components
    - dist
    - plugins

Log4j埋点

## Spring注解
 - `@Component`
需要在类上使用注解 @Component，该注解的 value 属性用于指定该 bean 的 id 值。
~~~ java
@Component(value = "student")
public class Student {
    private Long id;
    private String name;
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
~~~

Spring 还提供了 3 个功能基本和 @Component 等效的注解：

- @Repository：用于对 DAO 实现类进行注解
- @Service：用于对 Service 实现类进行注解
- @Controller：用于对 Controller 实现类进行注解

# @Scope

## 参考资料
> 前端工具
> https://github.com/ColorlibHQ/AdminLTE