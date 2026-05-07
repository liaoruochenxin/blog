# 用户登录接口测试用例

**接口**：`POST /api/user/login`

**Content-Type**：`application/json`

**响应格式**：`BaseResponse<UserLoginVO>`

- 成功：`{ "code": 0, "data": { "userAccount": "...", "userAvatar": "...", "userProfile": "..." }, "message": "ok" }`
- 失败：`{ "code": 40000, "data": null, "message": "<错误信息>" }`

---

## 1. 正常登录

> 前置条件：先通过注册接口创建测试用户（userAccount: "testuser", userPassword: "12345678"）

```json
{
  "userAccount": "testuser",
  "userPassword": "12345678"
}
```

**预期结果**：登录成功，返回 code=0，data 包含 userAccount、userAvatar、userProfile

---

## 2. 账号为空

```json
{
  "userAccount": "",
  "userPassword": "12345678"
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"用户账号不能为空"

---

## 3. 账号为 null

```json
{
  "userAccount": null,
  "userPassword": "12345678"
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"用户账号不能为空"

---

## 4. 密码为空

```json
{
  "userAccount": "testuser",
  "userPassword": ""
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"用户密码不能为空"

---

## 5. 密码为 null

```json
{
  "userAccount": "testuser",
  "userPassword": null
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"用户密码不能为空"

---

## 6. 用户不存在

> 前置条件：确保 "notexistuser" 未在系统中注册

```json
{
  "userAccount": "notexistuser",
  "userPassword": "12345678"
}
```

**预期结果**：业务校验失败，返回 code=40000，message="用户不存在"

---

## 7. 密码错误

> 前置条件：先通过注册接口创建测试用户（userAccount: "testuser", userPassword: "12345678"）

```json
{
  "userAccount": "testuser",
  "userPassword": "87654321"
}
```

**预期结果**：业务校验失败，返回 code=40000，message="密码错误"

---

## 8. 所有字段为空

```json
{}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含参数缺失信息
