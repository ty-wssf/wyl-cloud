import request from '@/utils/request'

const baseUrl = '/dict-service'

// 查询参数列表
export function pageList(query) {
  return request({
    url: baseUrl + '/config/pageList',
    method: 'get',
    params: query
  })
}

// 查询参数详细
export function getConfig(configId) {
  return request({
    url: baseUrl + '/config/' + configId,
    method: 'get'
  })
}

// 新增参数配置
export function addConfig(data) {
  return request({
    url: baseUrl + '/config',
    method: 'post',
    data: data
  })
}

// 编辑参数配置
export function editConfig(data) {
  return request({
    url: baseUrl + '/config',
    method: 'put',
    data: data
  })
}

// 删除参数配置
export function removeConfig(configId) {
  debugger
  return request({
    url: baseUrl + '/config/' + configId,
    method: 'delete'
  })
}
