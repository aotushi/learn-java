# Order Admin API

用于学习 Spring Boot 的最小订单 API。数据暂存在内存中，重启后清空；阶段 06 再替换为 MySQL。

## 测试与运行

```powershell
docker compose exec java mvn -f projects/order-admin-api/pom.xml test
docker compose --profile app up -d app
```

检查健康状态：

```powershell
Invoke-RestMethod http://localhost:8081/api/health
```

创建订单：

```powershell
$body = @{
    customerName = 'Alice'
    lines = @(
        @{ sku = 'JAVA-BOOK'; unitPriceMinor = 9900; quantity = 1 },
        @{ sku = 'USB-CABLE'; unitPriceMinor = 2500; quantity = 2 }
    )
} | ConvertTo-Json -Depth 4

Invoke-RestMethod `
    -Method Post `
    -Uri http://localhost:8081/api/orders `
    -ContentType 'application/json' `
    -Body $body
```

查询订单：

```powershell
Invoke-RestMethod http://localhost:8081/api/orders
Invoke-RestMethod http://localhost:8081/api/orders/1
```
