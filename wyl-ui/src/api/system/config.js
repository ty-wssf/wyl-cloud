import request from '@/utils/request'

// 查询参数列表
export function pageList(query) {
  return request({
    url: '/config/pageList',
    method: 'get',
    params: query
  })
}

// 新增参数配置
export function addConfig(data) {
  debugger
  return request({
    url: '/config',
    method: 'post',
    data: data
  })
}
