import request from '@/utils/request'

//获取商品列表
export function getProductList(params) {
  return request({
    url:'/product/list',
    method:'get',
    params:params
  })
}