import request from '@/utils/request'

const baseUrl = '/upms-service/sysUser'

// 分页列表
export function pageList(query) {
  return request({
    url: baseUrl + '/pageList',
    method: 'get',
    params: query
  })
}

// 根据主键查询详情
export function getInfo(id) {
  return request({
    url: baseUrl + '/' + id,
    method: 'get'
  })
}

// 新增
export function add(data) {
  return request({
    url: baseUrl,
    method: 'post',
    data: data
  })
}

// 编辑
export function edit(id, data) {
  return request({
    url: baseUrl + '/' + id,
    method: 'put',
    data: data
  })
}

// 删除
export function remove(id) {
  return request({
    url: baseUrl + '/' + id,
    method: 'delete'
  })
}
