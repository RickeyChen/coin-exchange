# 授权服务器

### 获取token
http://localhost:9999/oauth/token?grant_type=password&username=admin&password=123456
**返回结果**
```json
{
  "access_token": "xxxxxxxxx-xxx-xxxxx-xxxxxxx",
  "token_type": "bearer",
  "expires_in": 3599,
  "scope": "all"
}
```
# 停留在P28
