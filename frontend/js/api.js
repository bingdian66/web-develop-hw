// API 基础配置
const API_BASE_URL = 'http://localhost:8080/api';

// 通用请求函数
async function request(url, options = {}) {
    const config = {
        credentials: 'include',
        headers: {
            'Content-Type': 'application/json',
            ...options.headers
        },
        ...options
    };

    try {
        const response = await fetch(`${API_BASE_URL}${url}`, config);
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('API request failed:', error);
        throw error;
    }
}

// 认证相关 API
const authAPI = {
    // 登录
    login: (username, password) =>
        request('/auth/login', {
            method: 'POST',
            body: JSON.stringify({ username, password })
        }),

    // 注册
    register: (username, password) =>
        request('/auth/register', {
            method: 'POST',
            body: JSON.stringify({ username, password })
        }),

    // 登出
    logout: () =>
        request('/auth/logout', { method: 'POST' }),

    // 获取当前用户
    getCurrentUser: () =>
        request('/auth/current')
};

// 员工相关 API
const employeeAPI = {
    // 获取员工列表
    getList: (params) => {
        const query = new URLSearchParams(params).toString();
        return request(`/employees?${query}`);
    },

    // 获取员工详情
    getDetail: (id) =>
        request(`/employees/${id}`),

    // 添加员工
    create: (data) =>
        request('/employees', {
            method: 'POST',
            body: JSON.stringify(data)
        }),

    // 更新员工
    update: (id, data) =>
        request(`/employees/${id}`, {
            method: 'PUT',
            body: JSON.stringify(data)
        }),

    // 删除员工
    delete: (id) =>
        request(`/employees/${id}`, { method: 'DELETE' })
};

// 部门相关 API
const departmentAPI = {
    // 获取所有部门
    getAll: () =>
        request('/departments'),

    // 获取部门详情
    getDetail: (id) =>
        request(`/departments/${id}`),

    // 添加部门
    create: (data) =>
        request('/departments', {
            method: 'POST',
            body: JSON.stringify(data)
        }),

    // 更新部门
    update: (id, data) =>
        request(`/departments/${id}`, {
            method: 'PUT',
            body: JSON.stringify(data)
        })
};

// 考勤相关 API
const attendanceAPI = {
    // 获取考勤列表
    getList: (params) => {
        const query = new URLSearchParams(params).toString();
        return request(`/attendance?${query}`);
    },

    // 录入考勤
    create: (data) =>
        request('/attendance', {
            method: 'POST',
            body: JSON.stringify(data)
        }),

    // 获取考勤统计
    getStats: (params) => {
        const query = new URLSearchParams(params).toString();
        return request(`/attendance/stats?${query}`);
    },

    // 更新考勤
    update: (id, data) =>
        request(`/attendance/${id}`, {
            method: 'PUT',
            body: JSON.stringify(data)
        }),

    // 删除考勤
    delete: (id) =>
        request(`/attendance/${id}`, { method: 'DELETE' })
};

// 统计相关 API
const statsAPI = {
    // 总览统计
    getOverview: () =>
        request('/stats/overview'),

    // 部门统计
    getDepartment: () =>
        request('/stats/department'),

    // 入职统计
    getHire: () =>
        request('/stats/hire'),

    // 考勤统计
    getAttendance: () =>
        request('/stats/attendance')
};
