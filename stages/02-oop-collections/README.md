# 阶段 02：面向对象、集合与泛型

## 学习内容

- 类、对象、封装、构造器和不可变对象。
- 接口、组合、继承、抽象类和多态。
- `List`、`Set`、`Map`、泛型、迭代器和 Stream。
- 枚举状态、异常边界和 `Optional` 的合理使用。

## 阶段项目

将阶段 01 的订单计算拆分为：

- `LineItem`
- `DiscountPolicy` 接口
- `PercentageDiscount`
- `FixedAmountDiscount`
- `OrderTotalCalculator`
- `OrderTotalResult`

## 必做练习

1. 新增优惠策略时不修改计算器。
2. 使用 `Map<String, Product>` 根据 SKU 查商品。
3. 使用 `Set` 防止重复优惠码。
4. 明确订单允许的状态转换，拒绝非法转换。

## 验收

能够用业务需求解释为什么使用接口、集合或组合，而不是只背语法。
