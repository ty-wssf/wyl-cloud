import request from '@/utils/request'

// 查询参数列表
export function pageList(query) {
  return request({
    url: '/config/pageList',
    method: 'get',
    params: query
  })
}
