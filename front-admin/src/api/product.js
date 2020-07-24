import request from '@/utils/request'

//获取商品列表
export function getProductList(params) {
  return request({
    url:'/admin/product/list',
    method:'get',
    params:params
  })
}