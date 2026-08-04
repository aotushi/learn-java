# 阶段 08：Redis 与 RabbitMQ

## 启动

```powershell
docker compose --profile data --profile messaging up -d
docker compose exec redis redis-cli ping
docker compose exec rabbitmq rabbitmq-diagnostics -q ping
```

RabbitMQ 管理界面：<http://localhost:15673>

## Redis

- 缓存商品和库存查询，但数据库仍是事实来源。
- 设置明确过期时间和键命名规则。
- 更新数据后主动失效缓存。
- 防止缓存穿透、击穿和无限增长。

## RabbitMQ

- 理解生产者、交换机、路由、队列、消费者和确认。
- 低库存变化后发送通知消息。
- 处理重试、失败队列、重复投递和消费者崩溃。
- 使用业务唯一键保证幂等。

## 验收

重复消费同一消息不会重复扣库存或重复创建通知；失败任务可查询、可重试。
