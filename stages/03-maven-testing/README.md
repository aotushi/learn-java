# 阶段 03：Maven、测试与调试

## 学习内容

- Maven 的 `validate`、`compile`、`test`、`package` 和 `verify`。
- `pom.xml`、依赖范围、插件、缓存和版本冲突。
- JUnit 的正常、边界、异常和回归测试。
- 日志、调用栈、断点、最小复现和根因分析。

## 使用示例项目

```powershell
docker compose exec java mvn -f projects/order-admin-api/pom.xml test
docker compose exec java mvn -f projects/order-admin-api/pom.xml package
```

## 必做练习

1. 阅读 `OrderServiceTest`，先预测结果再运行。
2. 故意引入一个总额计算错误，写失败测试后修复。
3. 为订单不存在、空商品和溢出补测试。
4. 用 IDE 连接容器或使用本机编辑器设置断点调试。

## 验收

拿到一个 BUG 后能给出复现步骤、根因、最小修复和回归测试。
