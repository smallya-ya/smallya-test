import request from '@/utils/request'

// 查询演习管理列表
export function listBattle(query) {
  return request({
    url: '/drill/battle/list',
    method: 'get',
    params: query
  })
}

// 查询演习管理详细
export function getBattle(id) {
  return request({
    url: '/drill/battle/' + id,
    method: 'get'
  })
}

// 新增演习管理
export function addBattle(data) {
  return request({
    url: '/drill/battle',
    method: 'post',
    data: data
  })
}

// 修改演习管理
export function updateBattle(data) {
  return request({
    url: '/drill/battle',
    method: 'put',
    data: data
  })
}

// 删除演习管理
export function delBattle(id) {
  return request({
    url: '/drill/battle/' + id,
    method: 'delete'
  })
}
