# 阶段 05：Spring Boot 与 REST API

## 启动示例

```powershell
docker compose --profile app up -d app
docker compose logs -f app
```

打开另一个 PowerShell：

```powershell
Invoke-RestMethod http://localhost:8081/api/health
Invoke-RestMethod http://localhost:8081/api/orders
```

## 学习内容

- 自动配置、依赖注入和配置文件。
- Controller、Service、领域对象和依赖方向。
- HTTP 方法、状态码、JSON、验证和统一错误响应。
- 单元测试、Web 测试与集成测试。

## 必做练习

1. 新增取消订单接口，只允许 `CREATED` 状态取消。
2. 增加按订单号查询。
3. 为重复订单号返回 409。
4. 为分页接口增加明确的默认值和上限。
5. 不向客户端暴露 Java 调用栈或内部异常。

## 验收

API 对成功、非法输入、不存在和业务冲突返回合适的状态码与可读错误。
