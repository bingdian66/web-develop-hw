# 企业人事管理系统 - 快速启动指南 (Windows)

> Windows 系统从零开始的详细环境配置和启动步骤

---

## 目录

1. [环境准备](#环境准备)
2. [安装 Java 17](#安装-java-17)
3. [安装 Maven](#安装-maven)
4. [安装 Docker Desktop](#安装-docker-desktop)
5. [启动数据库](#启动数据库)
6. [启动后端](#启动后端)
7. [启动前端](#启动前端)
8. [功能测试](#功能测试)
9. [常见问题](#常见问题)

---

## 环境准备

### 系统要求

- **操作系统**: Windows 10 (64位) 或 Windows 11
- **网络**: 需要访问互联网（下载依赖）
- **磁盘空间**: 至少 5GB 可用空间
- **管理员权限**: 安装软件时需要

### 必需的软件

| 软件 | 最低版本 | 推荐版本 | 用途 |
|------|---------|---------|------|
| Java JDK | 17 | 17+ | 运行 Spring Boot |
| Maven | 3.6 | 3.8+ | 构建后端项目 |
| Docker Desktop | 20.10 | 最新版 | 运行 MySQL 容器 |
| 浏览器 | - | Chrome 最新版 | 访问前端 |

---

## 安装 Java 17

### 第一步：检查是否已安装 Java

按 `Win + R`，输入 `cmd`，按回车打开命令提示符，然后输入：

```cmd
java -version
```

**如果看到类似输出**：
```
java version "17.0.x" 或更高版本
```
说明已安装，**可以跳过此章节**。

**如果提示 "java 不是内部或外部命令"**，需要安装 Java。

---

### 第二步：下载 Java 17

#### 方式 1：通过官网下载（推荐，简单）

1. **打开浏览器访问**：https://adoptium.net/zh-CN/temurin/releases/
2. **选择以下选项**：
   - 操作系统：`Windows`
   - 架构：`x64`（64位）
   - 软件包类型：`JDK`
   - 版本：`17 - LTS`
3. **点击 `.msi` 安装包下载**（约 180MB）

#### 方式 2：通过命令行下载

打开 PowerShell（以管理员身份运行），输入：

```powershell
# 使用 winget 安装（Windows 11 自带，Windows 10 需先安装 App Installer）
winget install EclipseAdoptium.Temurin.17.JDK
```

---

### 第三步：安装 Java 17（通过 .msi 安装包）

1. **双击下载的 `.msi` 文件**
2. **点击 "Next"**
3. **重要：勾选 "Add to PATH"** ✅（这会自动配置环境变量）
4. **选择安装路径**（推荐默认：`C:\Program Files\Eclipse Adoptium\jdk-17.x.x-hotspot\`）
5. **点击 "Install"**
6. **等待安装完成**，点击 "Finish"

---

### 第四步：配置环境变量（如果安装时没有勾选 Add to PATH）

#### 4.1 配置 JAVA_HOME

1. **打开系统环境变量设置**：
   - 按 `Win + R`，输入 `sysdm.cpl`，按回车
   - 或右键 "此电脑" → "属性" → "高级系统设置"
2. **点击 "环境变量"**
3. **在 "系统变量" 区域，点击 "新建"**：
   - 变量名：`JAVA_HOME`
   - 变量值：`C:\Program Files\Eclipse Adoptium\jdk-17.0.x-hotspot`
   - （注意：替换为你实际的安装路径）
4. **点击 "确定"**

#### 4.2 配置 Path

1. **在 "系统变量" 中找到 `Path`，选中后点击 "编辑"**
2. **点击 "新建"**，添加：
   ```
   %JAVA_HOME%\bin
   ```
3. **点击 "确定"**，关闭所有窗口

---

### 第五步：验证 Java 安装

**关闭旧的命令提示符窗口**（环境变量需要重新加载）

**打开新的命令提示符**（`Win + R` → `cmd`），输入：

```cmd
java -version
javac -version
echo %JAVA_HOME%
```

**预期输出**：
```
java version "17.0.10" 2024-01-16 LTS
javac 17.0.10
C:\Program Files\Eclipse Adoptium\jdk-17.0.10-hotspot
```

✅ **如果看到以上输出，说明 Java 安装成功！**

---

## 安装 Maven

### 第一步：检查是否已安装 Maven

打开命令提示符，输入：

```cmd
mvn -version
```

**如果看到类似输出**：
```
Apache Maven 3.8.x
Java version: 17.0.x
```
说明已安装，**可以跳过此章节**。

---

### 第二步：下载 Maven

1. **访问 Maven 官网**：https://maven.apache.org/download.cgi
2. **找到 "Files" 区域**
3. **下载 `Binary zip archive`**（例如：`apache-maven-3.9.6-bin.zip`，约 9MB）

---

### 第三步：解压 Maven

1. **创建安装目录**：`C:\Program Files\Maven`
2. **解压下载的 zip 文件**到该目录
3. **确认路径**：`C:\Program Files\Maven\apache-maven-3.9.6\`

---

### 第四步：配置 Maven 环境变量

#### 4.1 配置 MAVEN_HOME

1. **打开环境变量设置**（`Win + R` → `sysdm.cpl` → "环境变量"）
2. **在 "系统变量" 区域，点击 "新建"**：
   - 变量名：`MAVEN_HOME`
   - 变量值：`C:\Program Files\Maven\apache-maven-3.9.6`
3. **点击 "确定"**

#### 4.2 配置 Path

1. **在 "系统变量" 中找到 `Path`，选中后点击 "编辑"**
2. **点击 "新建"**，添加：
   ```
   %MAVEN_HOME%\bin
   ```
3. **点击 "确定"**，关闭所有窗口

---

### 第五步：验证 Maven 安装

**关闭旧的命令提示符，打开新的命令提示符**，输入：

```cmd
mvn -version
echo %MAVEN_HOME%
```

**预期输出**：
```
Apache Maven 3.9.6
Maven home: C:\Program Files\Maven\apache-maven-3.9.6
Java version: 17.0.10
```

✅ **如果看到以上输出，说明 Maven 安装成功！**

---

### 第六步：配置 Maven 国内镜像（加速依赖下载）

1. **找到 Maven 配置文件**：
   ```
   C:\Program Files\Maven\apache-maven-3.9.6\conf\settings.xml
   ```

2. **右键 → 用记事本打开**

3. **找到 `<mirrors>` 标签**（约在第 160 行），在其中添加：

```xml
<mirrors>
  <mirror>
    <id>aliyun-maven</id>
    <mirrorOf>central</mirrorOf>
    <name>阿里云公共仓库</name>
    <url>https://maven.aliyun.com/repository/public</url>
  </mirror>
</mirrors>
```

4. **保存文件**（如果提示权限不足，以管理员身份打开记事本再编辑）

✅ **配置完成后，Maven 下载依赖会快很多！**

---

## 安装 Docker Desktop

### 第一步：检查是否已安装 Docker

打开命令提示符（或 PowerShell），输入：

```cmd
docker --version
docker compose version
```

**如果看到类似输出**：
```
Docker version 24.x.x
Docker Compose version v2.x.x
```
说明已安装，**可以跳过此章节**。

---

### 第二步：下载 Docker Desktop

1. **访问 Docker 官网**：https://www.docker.com/products/docker-desktop/
2. **点击 "Download for Windows"**（约 500MB）
3. **等待下载完成**

---

### 第三步：安装 Docker Desktop

1. **双击 `Docker Desktop Installer.exe`**
2. **在配置页面**：
   - ✅ **勾选 "Use WSL 2 instead of Hyper-V"**（推荐，性能更好）
   - 如果你的 Windows 版本不支持 WSL 2，使用 Hyper-V 也可以
3. **点击 "OK"**，等待安装
4. **安装完成后，点击 "Close and restart"**
5. **电脑会重启**（这是正常的）

---

### 第四步：启动 Docker Desktop

1. **重启后，从开始菜单找到并打开 "Docker Desktop"**
2. **等待 Docker 启动**（右下角图标会显示状态）
3. **看到 "Docker Desktop is running" 后，表示启动成功**

#### 如果提示安装 WSL 2

如果弹窗提示需要安装 WSL 2，执行以下步骤：

1. **以管理员身份打开 PowerShell**（右键开始菜单 → "Windows PowerShell (管理员)"）
2. **输入以下命令**：
   ```powershell
   wsl --install
   ```
3. **重启电脑**
4. **重新打开 Docker Desktop**

---

### 第五步：验证 Docker 安装

打开命令提示符，输入：

```cmd
docker --version
docker compose version
docker ps
```

**预期输出**：
```
Docker version 24.0.x
Docker Compose version v2.x.x
CONTAINER ID   IMAGE   COMMAND   CREATED   STATUS   PORTS   NAMES
```

✅ **如果看到以上输出（最后一行可能为空），说明 Docker 安装成功！**

---

## 启动数据库

### 第一步：打开项目目录

1. **按 `Win + R`**，输入 `cmd`，按回车
2. **进入项目根目录**（根据你的实际路径）：
   ```cmd
   cd D:\web-develop-hw
   ```
   或
   ```cmd
   cd C:\Users\你的用户名\Documents\web-develop-hw
   ```

---

### 第二步：启动 MySQL 容器

在项目根目录执行：

```cmd
docker compose up -d
```

**命令说明**：
- `up`：启动服务
- `-d`：后台运行

**预期输出**：
```
[+] Running 2/2
 ✔ Network web-develop-hw_default      Created
 ✔ Container hr-system-mysql           Started
```

**首次运行说明**：
- Docker 会下载 MySQL 8.0 镜像（约 500MB）
- 下载时间取决于你的网速（可能需要 5-10 分钟）

---

### 第三步：验证数据库启动

```cmd
docker ps
```

**预期输出**（应该看到一个运行中的容器）：
```
CONTAINER ID   IMAGE       COMMAND                  STATUS        PORTS                    NAMES
abc123def456   mysql:8.0   "docker-entrypoint.s…"   Up 1 minute   0.0.0.0:3306->3306/tcp   hr-system-mysql
```

✅ **看到 `Up X seconds/minutes` 表示数据库启动成功！**

---

### 第四步：验证数据库表

```cmd
docker exec -it hr-system-mysql mysql -uhruser -phrpass123 -e "USE hr_system; SHOW TABLES;"
```

**预期输出**：
```
+---------------------+
| Tables_in_hr_system |
+---------------------+
| t_admin             |
| t_attendance        |
| t_department        |
| t_employee          |
+---------------------+
```

✅ **看到 4 张表，说明数据库初始化成功！**

---

## 启动后端

### 第一步：打开新的命令提示符

**重要**：不要关闭数据库的命令提示符，打开一个新的。

1. **按 `Win + R`**，输入 `cmd`，按回车
2. **进入后端目录**：
   ```cmd
   cd D:\web-develop-hw\backend
   ```

---

### 第二步：启动 Spring Boot

```cmd
mvn spring-boot:run
```

**首次运行说明**：
- Maven 会下载所有依赖（约 200MB）
- 下载时间取决于网速（可能需要 5-10 分钟）
- 看到进度条下载是正常的，耐心等待

**预期输出（启动成功）**：
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.0)

...
Started HrSystemApplication in 4.256 seconds
```

✅ **看到 `Started HrSystemApplication` 表示后端启动成功！**

**保持这个窗口打开**，后端服务正在运行。

---

### 第三步：验证后端 API

**打开新的命令提示符**，输入：

```cmd
curl http://localhost:8080/api/departments
```

**预期输出**：
```json
{"code":200,"message":"success","data":[]}
```

✅ **看到 JSON 响应，说明后端 API 工作正常！**

---

## 启动前端

### 第一步：打开新的命令提示符

**打开第三个命令提示符窗口**（保持前面的数据库和后端窗口运行）。

**进入前端目录**：
```cmd
cd D:\web-develop-hw\frontend
```

---

### 第二步：启动静态服务器

#### 方式 1：使用 Python（推荐）

**检查是否已安装 Python**：
```cmd
python --version
```

**如果已安装 Python 3.x**：
```cmd
python -m http.server 8081
```

**预期输出**：
```
Serving HTTP on :: port 8081 (http://[::]:8081/) ...
```

#### 如果没有 Python

**快速安装 Python**：

1. **访问**：https://www.python.org/downloads/
2. **下载 Python 3.12（最新版）**
3. **安装时务必勾选 "Add Python to PATH"** ✅
4. **安装完成后，重新打开命令提示符，执行上面的命令**

---

#### 方式 2：使用浏览器直接打开（临时方案）

如果不想安装 Python，可以直接用浏览器打开 HTML 文件：

1. **在文件资源管理器中找到**：`D:\web-develop-hw\frontend\pages\login.html`
2. **右键 → 打开方式 → Chrome**

**注意**：这种方式可能遇到跨域问题，建议使用 Python 服务器。

---

### 第三步：访问系统

打开 Chrome 浏览器，访问：

```
http://localhost:8081/pages/login.html
```

✅ **看到登录页面，说明前端启动成功！**

---

## 功能测试

现在你有 **3 个命令提示符窗口在运行**：
1. 数据库（Docker）
2. 后端（Spring Boot）
3. 前端（Python HTTP Server）

**浏览器打开**：http://localhost:8081/pages/login.html

---

### 测试 1：管理员注册

1. **页面显示 "登录"**，点击下方 "没有账号？注册"
2. **输入用户名**：`admin`
3. **输入密码**：`admin123`
4. **点击 "注册" 按钮**

**预期结果**：✅ 自动跳转到首页（index.html）

---

### 测试 2：管理员登录

1. **返回登录页面**：http://localhost:8081/pages/login.html
2. **输入用户名**：`admin`
3. **输入密码**：`admin123`
4. **点击 "登录" 按钮**

**预期结果**：✅ 跳转到首页并显示欢迎信息

---

### 测试 3：部门管理

1. **在首页点击 "部门管理"**
2. **点击 "添加部门" 按钮**
3. **输入部门代码**：`DEV`
4. **输入部门名称**：`研发部`
5. **点击 "保存"**

**预期结果**：✅ 部门列表中显示新添加的 "研发部"

---

### 测试 4：员工管理

1. **点击 "员工管理"**
2. **点击 "添加员工"**
3. **填写员工信息**：
   - 工号：`E001`
   - 姓名：`张三`
   - 部门：选择 `研发部`
   - 职位：`Java 工程师`
   - 入职日期：选择今天
   - 联系电话：`13800138000`
4. **点击 "保存"**

**预期结果**：✅ 员工列表中显示新员工 "张三"

---

### 测试 5：考勤管理

1. **点击 "考勤管理"**
2. **点击 "录入考勤"**
3. **选择员工**：`张三`
4. **选择日期**：今天
5. **选择状态**：`正常`
6. **点击 "保存"**

**预期结果**：✅ 考勤记录列表中显示今天的考勤记录

---

### 测试 6：统计报表

1. **点击 "统计报表"**
2. **查看各项统计数据**：
   - 员工总数：1
   - 部门总数：1
   - 本月入职人数：1
   - 整体出勤率：应该显示百分比

**预期结果**：✅ 所有统计数据正确显示

---

### 测试 7：搜索功能

1. **返回 "员工管理"**
2. **在搜索框输入**：`张三`
3. **点击搜索**

**预期结果**：✅ 只显示包含 "张三" 的员工

---

### 测试 8：退出登录

1. **点击 "退出登录"**

**预期结果**：✅ 返回登录页面

---

## 系统架构图

```
┌─────────────────────────────────────────────────────┐
│                Chrome 浏览器                         │
│        http://localhost:8081/pages/login.html       │
└─────────────────┬───────────────────────────────────┘
                  │
                  │ HTTP Request (fetch API)
                  │
┌─────────────────▼───────────────────────────────────┐
│         前端静态服务器 (Python HTTP Server)          │
│                   Port: 8081                         │
└─────────────────┬───────────────────────────────────┘
                  │
                  │ API Request: /api/...
                  │
┌─────────────────▼───────────────────────────────────┐
│      Spring Boot 后端 (Maven 运行)                   │
│   Controller → Service → Mapper → 数据库             │
│                   Port: 8080                         │
└─────────────────┬───────────────────────────────────┘
                  │
                  │ JDBC Connection
                  │
┌─────────────────▼───────────────────────────────────┐
│      MySQL 8.0 数据库 (Docker 容器)                  │
│              hr_system database                      │
│                   Port: 3306                         │
└─────────────────────────────────────────────────────┘
```

---

## 常见问题

### 问题 1：端口被占用

**现象**：
```
Error: Port 3306/8080/8081 is already in use
```

**解决方案**：

1. **查看占用端口的进程**：
   ```cmd
   netstat -ano | findstr :3306
   netstat -ano | findstr :8080
   netstat -ano | findstr :8081
   ```

2. **记下最后一列的 PID（进程ID）**

3. **结束进程**：
   ```cmd
   taskkill /PID <进程ID> /F
   ```

**或者修改端口**：
- MySQL: 修改 `docker-compose.yml` → `ports: "3307:3306"`
- 后端: 修改 `backend/src/main/resources/application.yml` → `server.port: 8888`
- 前端: 使用不同端口 `python -m http.server 8082`

---

### 问题 2：Docker Desktop 启动失败

**现象**：Docker Desktop 一直显示 "Starting..."

**解决方案**：

1. **检查 WSL 2 是否安装**：
   ```cmd
   wsl --status
   ```

2. **如果未安装，以管理员身份运行 PowerShell**：
   ```powershell
   wsl --install
   ```

3. **重启电脑**

4. **重新打开 Docker Desktop**

---

### 问题 3：Maven 下载依赖失败

**现象**：
```
Failed to download artifact from central repository
```

**解决方案**：

1. **确认已配置阿里云镜像**（见 [第六步：配置 Maven 国内镜像](#第六步配置-maven-国内镜像加速依赖下载)）

2. **清除 Maven 缓存**：
   ```cmd
   rmdir /S /Q %USERPROFILE%\.m2\repository
   ```

3. **重新运行**：
   ```cmd
   mvn spring-boot:run
   ```

---

### 问题 4：后端连接数据库失败

**现象**：
```
Communications link failure with MySQL
```

**解决方案**：

1. **检查 MySQL 容器是否运行**：
   ```cmd
   docker ps | findstr mysql
   ```

2. **如果没有看到容器，重新启动**：
   ```cmd
   docker compose up -d
   ```

3. **等待 30 秒让数据库完全启动**，再启动后端

---

### 问题 5：前端无法访问（404 错误）

**现象**：浏览器显示 "无法访问此网站"

**解决方案**：

1. **确认 Python 服务器正在运行**（命令提示符窗口应该显示日志）

2. **检查端口是否正确**：http://localhost:8081

3. **尝试使用 127.0.0.1**：http://127.0.0.1:8081/pages/login.html

---

### 问题 6：登录后立即退出

**现象**：登录成功但跳转后显示未登录

**解决方案**：

1. **清除浏览器缓存和 Cookie**：
   - Chrome: `Ctrl + Shift + Delete` → 清除缓存和 Cookie

2. **使用相同域名**：都用 `localhost`，不要混用 `127.0.0.1`

3. **检查浏览器设置**：确保允许第三方 Cookie

---

### 问题 7：环境变量设置后不生效

**现象**：设置了 `JAVA_HOME` 但 `java -version` 仍然报错

**解决方案**：

1. **关闭所有命令提示符窗口**

2. **重新打开新的命令提示符**（环境变量需要重新加载）

3. **如果还不行，重启电脑**

---

## 停止服务

### 停止前端

在前端的命令提示符窗口按：`Ctrl + C`

### 停止后端

在后端的命令提示符窗口按：`Ctrl + C`

### 停止数据库

```cmd
# 停止容器（保留数据）
docker compose stop

# 停止并删除容器（不删除数据卷）
docker compose down

# 停止并删除容器和数据（慎用！）
docker compose down -v
```

---

## 重启服务

```cmd
# 1. 启动数据库
cd D:\web-develop-hw
docker compose up -d

# 2. 启动后端（新的命令提示符）
cd D:\web-develop-hw\backend
mvn spring-boot:run

# 3. 启动前端（新的命令提示符）
cd D:\web-develop-hw\frontend
python -m http.server 8081

# 4. 访问
start http://localhost:8081/pages/login.html
```

---

## 快速启动批处理脚本（可选）

创建一个 `start.bat` 文件，内容如下：

```batch
@echo off
echo 🚀 启动 HR 系统...

echo 📦 启动数据库...
docker compose up -d

echo ⏳ 等待数据库初始化...
timeout /t 10 /nobreak

echo 🔧 启动后端...
start cmd /k "cd backend && mvn spring-boot:run"

echo ⏳ 等待后端启动...
timeout /t 15 /nobreak

echo 🌐 启动前端...
start cmd /k "cd frontend && python -m http.server 8081"

echo ⏳ 等待前端启动...
timeout /t 3 /nobreak

echo ✅ 系统启动完成！
echo 📱 正在打开浏览器...
start http://localhost:8081/pages/login.html

pause
```

**使用方法**：
1. 将以上内容保存为 `start.bat`
2. 放在项目根目录（`D:\web-develop-hw\start.bat`）
3. 双击运行即可自动启动所有服务

---

## 总结

### 完整的启动流程

1. ✅ **安装 Java 17** → 配置 `JAVA_HOME` → 验证 `java -version`
2. ✅ **安装 Maven** → 配置环境变量 → 配置国内镜像 → 验证 `mvn -version`
3. ✅ **安装 Docker Desktop** → 启动 Docker → 验证 `docker ps`
4. ✅ **启动数据库**：`docker compose up -d`
5. ✅ **启动后端**：`cd backend && mvn spring-boot:run`
6. ✅ **启动前端**：`cd frontend && python -m http.server 8081`
7. ✅ **访问系统**：http://localhost:8081/pages/login.html
8. ✅ **测试功能**：注册 → 登录 → 使用各模块

---

**🎉 现在你的组员可以按照这个指南从零开始配置和启动系统了！**

---

## 附录：命令速查表

| 操作 | 命令 |
|------|------|
| 检查 Java | `java -version` |
| 检查 Maven | `mvn -version` |
| 检查 Docker | `docker --version` |
| 启动数据库 | `docker compose up -d` |
| 查看容器 | `docker ps` |
| 启动后端 | `mvn spring-boot:run` |
| 启动前端 | `python -m http.server 8081` |
| 停止数据库 | `docker compose down` |
| 查看端口占用 | `netstat -ano \| findstr :8080` |
| 结束进程 | `taskkill /PID <进程ID> /F` |

---

**有问题？参考 [常见问题](#常见问题) 章节或联系技术支持。**
