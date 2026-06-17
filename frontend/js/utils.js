// 认证检查（用于需要登录的页面）
async function checkAuth() {
    try {
        const data = await authAPI.getCurrentUser();
        if (data.code !== 200) {
            location.href = 'login.html';
            return null;
        }
        return data.data;
    } catch (error) {
        location.href = 'login.html';
        return null;
    }
}

// 页面跳转
function navigate(page) {
    location.href = page;
}

// 显示错误信息
function showError(elementId, message) {
    const el = document.getElementById(elementId);
    if (el) {
        el.textContent = message;
        el.style.display = 'block';
    }
}

// 清除错误信息
function clearError(elementId) {
    const el = document.getElementById(elementId);
    if (el) {
        el.textContent = '';
        el.style.display = 'none';
    }
}

// 格式化日期
function formatDate(dateString) {
    if (!dateString) return '';
    const date = new Date(dateString);
    return date.toLocaleDateString('zh-CN');
}

// 确认对话框
function confirm(message) {
    return window.confirm(message);
}
