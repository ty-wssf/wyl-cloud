import request from '@/utils/request'

// 查询参数列表
export function pageList(query) {
  return request({
    url: '/config/pageList',
    method: 'get',
    params: query,
    baseURL: 'http://localhost:9000' // 直接通过覆盖的方式
  })
}
