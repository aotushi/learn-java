# 阶段 00：环境与工具

如果 Docker 已经忘记，先完成 [Docker 轻量伴学](../../docs/docker-light-guide.md) 的 10 分钟练习。

## 目标

- 会启动和停止 Java 容器。
- 会在容器中执行 Java、Maven 和测试。
- 理解 JDK、JVM、源码、字节码和 JAR 的基本关系。
- 遇到问题会先查看状态和日志。

## 开始

```powershell
docker compose up -d java
docker compose exec java java --version
docker compose exec java mvn --version
docker compose exec java java stages/00-environment/Hello.java
docker compose ps
```

Java 支持直接启动单个源码文件，因此第一阶段不需要手工运行 `javac`。

## 必做练习

1. 修改 `Hello.java` 的名字和学习目标，再运行一次。
2. 在容器中执行 `pwd`、`ls -la`、`java --version` 和 `mvn --version`。
3. 用 `docker compose stop java` 停止，再重新启动。

## 验收

能解释“代码在 Windows，Java 在容器中运行”，并能独立执行示例。
