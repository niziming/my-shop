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

## 容器中 Bean 的作用域
在学习 Bean 的装配方式之前，我们先了解一下 Bean 的作用域。当通过 Spring 容器创建一个 Bean 实例时，不仅可以完成 Bean 的实例化，还可以通过 scope 属性，为 Bean 指定特定的作用域。Spring 支持 5 种作用域。

- singleton：单态模式。即在整个 Spring 容器中，使用 singleton 定义的 Bean 将是单例的，只有一个实例。默认为单态的。
- prototype：原型模式。即每次使用 getBean 方法获取的同一个 <bean /> 的实例都是一个新的实例。
- request：对于每次 HTTP 请求，都将会产生一个不同的 Bean 实例。
- session：对于每个不同的 HTTP session，都将产生一个不同的 Bean 实例。
- global session：每个全局的 HTTP session 对应一个 Bean 实例。典型情况下，仅在使用 portlet 集群时有效，多个 Web 应用共享一个 session。一般应用中，global-session 与 session 是等同的。

**notice**:
- 对于 scope 的值 request、session 与 global session，只有在 Web 应用中使用 Spring 时，该作用域才有效。
- 对于 scope 为 singleton 的单例模式，该 Bean 是在容器被创建时即被装配好了。
- 对于 scope 为 prototype 的原型模式，Bean 实例是在代码中使用该 Bean 实例时才进行装配的。
           
## 基于注解的装配方式
对于 DI 使用注解，将不再需要在 Spring 配置文件中声明 Bean 实例。Spring 中使用注解， 需要在原有 Spring 运行环境基础上再做一些改变
~~~ xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd 
       http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
">

    <context:annotation-config />
    <context:component-scan base-package="com.funtl.leeshop"/>
</beans>
~~~

Spring 还提供了 3 个功能基本和 @Component 等效的注解：
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
- @Repository：用于对 DAO 实现类进行注解
- @Service：用于对 Service 实现类进行注解
- @Controller：用于对 Controller 实现类进行注解

## @Scope
需要在类上使用注解 @Scope，其 value 属性用于指定作用域。默认为 singleton。
~~~ java

~~~

## @Value
## @Autowired
## @Resource
## @PostConstruc

## 参考资料
> 前端工具
> https://github.com/ColorlibHQ/AdminLTE