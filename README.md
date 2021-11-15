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

