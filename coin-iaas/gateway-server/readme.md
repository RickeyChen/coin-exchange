## Gateway 要求

1. 性能:API高可用;负载均衡;容错;
2. 安全:权限认证;黑白名单;
3. 日志:
4. 缓存:数据缓存;
5. 监控:记录请求响应数据,api耗时,性能监控;
6. 限流
7. 灰度
8. 路由:动态路由

## 数据链路
Nginx(作为全局门户网关) -> Gateway(熔断,重试) -> Micro Service

## 限流纬度
1. 对某个微服务整体限流
2. 对API分组限流
```text
// gw-flow.json
{ 
    "resource": "[资源名称] 1. 网关:routes.id; 2. api分组: api分组名称",
    "resourceMode": "网关:0; api分组:1;",
    "intervalSec": 60,
    "count": 5
}
```