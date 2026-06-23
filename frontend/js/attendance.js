// attendance.js
// 考勤管理页面逻辑（attendance.html）
//
// 负责考勤页面的交互与渲染：
//   - init()          页面初始化：校验登录、加载员工下拉、加载考勤列表
//   - loadEmployees() 加载员工列表，填充筛选与表单的下拉选项
//   - loadData()      按员工/月份分页查询并渲染考勤表格
//   - loadStats()     查询并渲染考勤统计（总天数、正常、缺勤、请假、病假、出勤率）
//   - showModal/hideModal  显示/隐藏新增或编辑弹窗
//   - edit(id)        载入指定记录到表单进行编辑
//   - save()          保存（新增或更新）考勤记录
//   - del(id)         删除考勤记录
//   - prevPage/nextPage  分页翻页
