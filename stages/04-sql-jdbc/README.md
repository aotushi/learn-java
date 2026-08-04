# 阶段 04：MySQL 与 JDBC

## 启动数据环境

```powershell
docker compose --profile data up -d
docker compose --profile data ps
docker compose exec mysql mysql -ulearner -plearner-local-only learn_java
```

首次启动会创建 `inventory_item` 表和两条示例库存。

## 学习内容

- 表、主键、唯一约束、外键和关系建模。
- 查询、连接、聚合、事务、隔离级别和锁。
- 索引、`EXPLAIN`、分页和慢查询。
- JDBC、参数绑定、连接池、迁移和资源关闭。

## 必做练习

1. 设计 `warehouse`、`inventory_transaction`、`sales_order` 和 `sales_order_line`。
2. 在一个事务中创建出库记录并扣减库存。
3. 模拟中途失败，确认所有修改一起回滚。
4. 使用 `UPDATE ... WHERE available_quantity >= ?` 防止负库存。
5. 为 SKU、订单号和时间范围查询分析索引。

## 验收

能够根据具体查询解释索引，并能说明事务保护的业务边界。
