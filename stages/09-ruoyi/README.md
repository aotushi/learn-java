# 阶段 09：RuoYi 阅读与扩展

本阶段使用官方 RuoYi-Vue 单体版。暂不学习 RuoYi-Cloud，先掌握单体项目的权限、事务和排错。

官方资料：

- [RuoYi-Vue 文档](https://doc.ruoyi.vip/ruoyi-vue/)
- [RuoYi-Vue 官方仓库](https://github.com/yangzongzhuan/RuoYi-Vue)

需要时将源码下载到被忽略的练习目录：

```powershell
git clone --depth 1 https://github.com/yangzongzhuan/RuoYi-Vue.git stages/09-ruoyi/app
docker compose --profile data --profile frontend up -d
```

## 阅读顺序

1. 多模块 Maven 目录和启动入口。
2. 登录、JWT、Spring Security 过滤链。
3. 用户、角色、菜单和按钮权限。
4. 数据权限与 SQL 拦截。
5. 操作日志、异常处理和定时任务。
6. MyBatis、代码生成器和前后端接口。

## 开发任务

在不修改框架核心逻辑的前提下新增 `inventory` 业务模块：

- 商品和仓库菜单。
- 列表、详情、新增和调整库存。
- 菜单与按钮权限。
- 仓库数据范围。
- 库存调整审计日志。
- 关键业务自动测试。

## 验收

能够解释一次受保护请求的完整路径；不依赖代码生成器也能独立增加一个字段或业务规则。
