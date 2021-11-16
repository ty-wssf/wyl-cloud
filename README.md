# 系统简介

基于领域驱动设计（DDD）的微服务开发框架.

## 系统模块
~~~
com.wyl     
├── wyl-components          // 组件模块
├── ruoyi-modules         // 业务模块
│       └── dict                              // 字典模块 [9301]
├──pom.xml                // 公共依赖
~~~

## 开发流程

- 使用cola骨架创建微服务模块

  ```xml
  <archetype groupId="com.alibaba.cola" artifactId="cola-framework-archetype-service" version="4.0.1" />
  ```

- 使用mybatisX插件生成基础设施层代码

## **方法名约定：**

| 层次             | 类         | 方法名约定                                                   |
| :--------------- | :--------- | :----------------------------------------------------------- |
| App层            | 接口服务   | 新增：save <br />修改：modify <br />查询：get（单个）、list（多个、分页） <br />统计：count <br />删除：remove |
| Domain层         | Domain实体 | 尽量避免CRUD形式的命名，要体现业务语义                       |
| Infrastructure层 | Tunnel对象 | 新增：insert<br />修改：update <br />查询： get(单个) 、select(多个)、page（分页） <br />删除：delete <br />统计：count |



## 参考资料

- [SOFA 应用架构详解](https://www.freesion.com/article/8731164709/)
- [领域驱动设计实践：以DDD视角看SOFA](https://blog.csdn.net/weixin_44273302/article/details/117755023)
- [DDD实战课（实战篇）--学习笔记](https://www.cnblogs.com/MingsonZheng/p/14904628.html?ivk_sa=1024320u)


