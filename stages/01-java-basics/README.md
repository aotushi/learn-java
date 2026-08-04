# 阶段 01：Java 基础

## 学习内容

- 变量、基本类型、字符串、运算符和类型转换。
- 条件、循环、方法、数组和参数。
- `record`、枚举、日期时间和异常入门。
- 金额使用整数最小单位或 `BigDecimal`，避免 `double` 误差。

## 运行示例

```powershell
docker compose exec java java stages/01-java-basics/OrderTotal.java
```

## 必做练习

1. 增加“满 500 元减 50 元”。
2. 增加“满 299 元免运费，否则 20 元”。
3. 对空 SKU、负价格和零数量给出明确错误。
4. 从命令行参数读取客户等级。
5. 准备恰好达到优惠门槛等边界案例。

## 验收问题

- `int`、`long` 和 `BigDecimal` 分别适合什么场景？
- `==` 与 `equals` 有什么不同？
- 受检异常和运行时异常有什么区别？
