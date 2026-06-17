let currentId = null;

async function init() {
    await checkAuth();
    await loadData();
}

async function loadData() {
    const data = await departmentAPI.getAll();
    if (data.code === 200) {
        const list = data.data;
        document.getElementById('tbody').innerHTML = list.map(d => `
            <tr>
                <td>${d.deptCode}</td>
                <td>${d.deptName}</td>
                <td class="actions">
                    <button class="btn-primary" onclick="edit(${d.id})">编辑</button>
                </td>
            </tr>
        `).join('');
    }
}

function showModal(id) {
    currentId = id || null;
    document.getElementById('modalTitle').textContent = id ? '编辑部门' : '添加部门';
    if (!id) {
        document.getElementById('deptCode').value = '';
        document.getElementById('deptName').value = '';
    }
    document.getElementById('modal').style.display = 'flex';
}

function hideModal() {
    document.getElementById('modal').style.display = 'none';
}

async function edit(id) {
    const data = await departmentAPI.getDetail(id);
    if (data.code === 200) {
        const d = data.data;
        document.getElementById('deptCode').value = d.deptCode;
        document.getElementById('deptName').value = d.deptName;
        showModal(id);
    }
}

async function save() {
    const body = {
        deptCode: document.getElementById('deptCode').value,
        deptName: document.getElementById('deptName').value
    };

    const data = currentId
        ? await departmentAPI.update(currentId, body)
        : await departmentAPI.create(body);

    if (data.code === 200) {
        hideModal();
        loadData();
    }
}

init();
