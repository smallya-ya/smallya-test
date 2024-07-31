import request from '@/utils/request'

export function ranking(data) {
  return request({
    url: '/bigscreen/ranking/list',
    method: 'put',
    data: data
  })
}
