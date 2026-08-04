# Java 与 Spring Boot 学习项目

这是一个使用 Docker 的分阶段 Java 学习项目。目标是从语言基础逐步走到企业后台开发，并最终完成一个独立的进销存与订单管理后台。

本项目与 `learn-php` 平级、互不依赖：

- `learn-php`：PHP 与 Magento 全栈商城。
- `learn-java`：Java、Spring Boot 与 RuoYi 企业后台。
- 两者只共享 Docker 学习方法，不默认进行系统对接。

学习主线：

> Java 语法 → 面向对象与集合 → Maven 与测试 → SQL/JDBC → Spring Boot → 数据与事务 → 权限与安全 → 缓存和消息队列 → RuoYi → 进销存综合项目

## 环境版本

| 组件 | 版本 | 用途 |
| --- | --- | --- |
| Java | 25 LTS | Java 学习和应用运行时 |
| Maven | 3.9 | 构建、依赖与测试 |
| Spring Boot | 4.1.0 | Web 与企业应用框架 |
| MySQL | 8.4 | 关系数据库 |
| Redis | 7.4 | 缓存、会话与分布式基础练习 |
| RabbitMQ | 4.2 | 异步消息队列 |
| Node.js | 22 | RuoYi 前端环境 |
| RuoYi-Vue | 3.9.x | 后期后台框架阅读与扩展 |

## 5 分钟开始

如果 Docker 已经忘记，先阅读 [Docker 轻量伴学](docs/docker-light-guide.md)。

```powershell
cd E:\code\github\learn-java
Copy-Item .env.example .env
docker compose up -d java
docker compose exec java java --version
docker compose exec java mvn --version
docker compose exec java java stages/00-environment/Hello.java
```

运行 Spring Boot 示例的自动测试：

```powershell
docker compose exec java mvn -f projects/order-admin-api/pom.xml test
```

启动示例 API：

```powershell
docker compose --profile app up -d app
Invoke-RestMethod http://localhost:8081/api/health
```

停止环境不会删除学习数据：

```powershell
docker compose --profile app --profile data --profile messaging --profile frontend stop
```

> 暂时不要使用 `docker compose down -v`，其中的 `-v` 会删除本项目的数据库、缓存和队列数据。

## 学习阶段

| 阶段 | 目录 | 建议时间 | 完成标志 |
| --- | --- | ---: | --- |
| 00 | `stages/00-environment` | 1–2 天 | 会用 Docker 执行 Java 和 Maven |
| 01 | `stages/01-java-basics` | 2 周 | 能独立完成命令行订单计算 |
| 02 | `stages/02-oop-collections` | 2 周 | 会用对象、集合和泛型表达业务 |
| 03 | `stages/03-maven-testing` | 2 周 | 会组织项目、测试和调试 |
| 04 | `stages/04-sql-jdbc` | 2 周 | 会设计表、事务、索引和 JDBC |
| 05 | `stages/05-spring-boot` | 3 周 | 会开发有验证和错误处理的 REST API |
| 06 | `stages/06-data-transactions` | 2 周 | 理解持久化、事务和并发更新 |
| 07 | `stages/07-security` | 2 周 | 会实现登录、角色、权限和审计 |
| 08 | `stages/08-cache-messaging` | 2 周 | 会使用缓存和可靠消息 |
| 09 | `stages/09-ruoyi` | 3 周 | 能阅读并扩展 RuoYi，而非只会生成代码 |
| 10 | `stages/10-capstone` | 4 周 | 完成可安装、可测试的进销存后台 |

完整计划见 [24 周学习路线](docs/learning-path.md)，最终项目见 [综合项目说明](docs/capstone.md)，学习记录见 [进度清单](docs/progress-checklist.md)。

## 当前示例项目

`projects/order-admin-api` 是一个小型订单 API，用于贯穿 Maven、测试和 Spring Boot 阶段。它故意不使用数据库或 RuoYi，让初学阶段可以直接看到订单规则如何工作。后续阶段再逐步替换为 MySQL、权限和消息队列。
