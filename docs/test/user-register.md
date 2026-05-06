# 用户注册接口测试用例

**接口**：`POST /api/user/register`

**Content-Type**：`application/json`

**响应格式**：`BaseResponse<Long>`

- 成功：`{ "code": 0, "data": <用户ID>, "message": "ok" }`
- 失败：`{ "code": 40000, "data": null, "message": "<错误信息>" }`

---

## 1. 正常注册

```json
{
  "userAccount": "testuser",
  "userPassword": "12345678",
  "checkPassword": "12345678"
}
```

**预期结果**：注册成功，返回 code=0，data 为新用户 ID

---

## 2. 账号为空

```json
{
  "userAccount": "",
  "userPassword": "12345678",
  "checkPassword": "12345678"
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"账号不能为空"

---

## 3. 账号为 null

```json
{
  "userAccount": null,
  "userPassword": "12345678",
  "checkPassword": "12345678"
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"账号不能为空"

---

## 4. 账号长度不足（小于4位）

```json
{
  "userAccount": "abc",
  "userPassword": "12345678",
  "checkPassword": "12345678"
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"账号长度不能小于4位"

---

## 5. 密码为空

```json
{
  "userAccount": "testuser2",
  "userPassword": "",
  "checkPassword": "12345678"
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"密码不能为空"

---

## 6. 密码为 null

```json
{
  "userAccount": "testuser3",
  "userPassword": null,
  "checkPassword": "12345678"
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"密码不能为空"

---

## 7. 密码长度不足（小于8位）

```json
{
  "userAccount": "testuser4",
  "userPassword": "1234567",
  "checkPassword": "1234567"
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"密码长度不能小于8位"

---

## 8. 确认密码为空

```json
{
  "userAccount": "testuser5",
  "userPassword": "12345678",
  "checkPassword": ""
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"确认密码不能为空"

---

## 9. 确认密码为 null

```json
{
  "userAccount": "testuser6",
  "userPassword": "12345678",
  "checkPassword": null
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"确认密码不能为空"

---

## 10. 确认密码长度不足（小于8位）

```json
{
  "userAccount": "testuser7",
  "userPassword": "12345678",
  "checkPassword": "1234567"
}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含"确认密码长度不能小于8位"

---

## 11. 两次密码不一致

```json
{
  "userAccount": "testuser8",
  "userPassword": "12345678",
  "checkPassword": "87654321"
}
```

**预期结果**：业务校验失败，返回 code=40000，message="两次输入密码不一致"

---

## 12. 账号已存在

> 前置条件：先执行用例1完成注册，再使用相同账号重复注册

```json
{
  "userAccount": "testuser",
  "userPassword": "12345678",
  "checkPassword": "12345678"
}
```

**预期结果**：业务校验失败，返回 code=40000，message="账号已存在"

---

## 13. 所有字段为空

```json
{}
```

**预期结果**：参数校验失败，返回 code=40000，message 包含参数缺失信息
