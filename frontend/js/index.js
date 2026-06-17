async function init() {
    const user = await checkAuth();
    if (user) {
        document.getElementById('user').textContent = `欢迎，${user.username}`;
    }
}

async function logout() {
    await authAPI.logout();
    navigate('login.html');
}

init();
