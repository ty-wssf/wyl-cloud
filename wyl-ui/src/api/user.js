import request from '@/utils/request'

const baseUrl = '/dict-service'

export function login(data) {
  return request({
    url: baseUrl + '/vue-admin-template/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: baseUrl + '/vue-admin-template/user/info',
    method: 'get',
    params: {token}
  })
}

export function logout() {
  return request({
    url: baseUrl + '/vue-admin-template/user/logout',
    method: 'post'
  })
}
