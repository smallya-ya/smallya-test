import request from '@/utils/request'

export function addmap(data) {
  return request({
    url: '/system/test/test',
    method: 'post',
    data: data
  })
}
