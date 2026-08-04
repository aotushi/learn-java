# Docker 轻量伴学

这份文档只讲 `learn-java` 每天真正会用到的 Docker 内容。你可以一边学 Java，一边恢复 Docker，不需要先学习完整的 Docker 课程。

## 只记住 5 个概念

| 名称 | 本项目中的含义 |
| --- | --- |
| 镜像 | 已装好 Java、Maven 或数据库的环境模板 |
| 容器 | 根据镜像启动的运行环境 |
| Compose | 按 `compose.yaml` 统一启动服务 |
| 挂载 | Windows 与容器共享项目代码 |
| 数据卷 | 保存 Maven 缓存、数据库和队列数据 |

## 每天只用 5 个动作

```powershell
# 1. 启动 Java 环境
docker compose up -d java

# 2. 在容器中执行命令
docker compose exec java java --version

# 3. 查看状态
docker compose ps

# 4. 出错时查看日志
docker compose logs --tail 50 java

# 5. 学完后停止
docker compose stop java
```

`stop` 不会删除代码、镜像或数据。下次重新执行 `up -d java` 即可。

## 10 分钟练习

```powershell
docker compose up -d java
docker compose exec java java --version
docker compose exec java mvn --version
docker compose exec java java stages/00-environment/Hello.java
docker compose ps
docker compose logs --tail 10 java
docker compose stop java
docker compose up -d java
```

完成后只需理解：`up` 启动、`exec` 执行、`ps` 看状态、`logs` 看记录、`stop` 停止。

## 按阶段增加服务

| 学习内容 | 命令 | 新接触的概念 |
| --- | --- | --- |
| Java、Maven、测试 | `docker compose up -d java` | 容器、挂载、执行命令 |
| Spring Boot API | `docker compose --profile app up -d` | 端口与浏览器访问 |
| MySQL 与 Redis | `docker compose --profile data up -d` | 多容器通信与数据卷 |
| RabbitMQ | `docker compose --profile messaging up -d` | 队列服务与健康检查 |
| RuoYi 前端 | `docker compose --profile frontend up -d` | Node.js 前端环境 |

不要一开始启动全部服务。需要什么才启动什么。

## 最小排错顺序

```powershell
docker version
docker compose ps -a
docker compose logs --tail 100 服务名
docker compose restart 服务名
```

- `docker version` 失败：确认 Docker Desktop 已启动。
- 找不到服务：确认当前目录是 `learn-java`。
- 服务停止：先看日志，再重新启动。
- 端口被占用：修改 `.env` 中本项目端口，不要删除其他项目。

## 安全边界

日常可使用：`up`、`exec`、`ps`、`logs`、`restart`、`stop`、`down`。

暂时不要自行使用：

```text
docker compose down -v
docker system prune
docker volume rm
```

这些命令可能删除数据库数据、构建缓存或其他项目资源。

现阶段能启动环境、执行 Java/Maven、查看状态和日志就够了。
