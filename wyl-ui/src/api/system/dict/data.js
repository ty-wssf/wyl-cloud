import request from '@/utils/request'

const baseUrl = '/dict-service'

// 根据字典类型查询字典数据信息
export function getDicts(dictType) {
  return request({
    url: baseUrl + '/dict/data/type/' + dictType,
    method: 'get'
  })
}
