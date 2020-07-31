import axios from 'axios'
import { Message } from 'element-ui'

// 创建axios实例
const service = axios.create({
  // api的base_url
  baseURL: "http://localhost:9001/admin",
  // 请求超时时间
  timeout: 10000
})

// respone拦截器
service.interceptors.response.use(
  response => {
    // code为非200是抛错 可结合自己业务进行修改
    const res = response.data
    if (res.code !== "0") {
      Message({
        message: res.message,
        type: 'error',
        duration: 1 * 1000
      })
      return Promise.reject(res.message)
    } else {
      return response.data
    }
  },
  error => {
    // for debug
    console.log(error)
    // 获取错误信息
    var errMessage = error.message
    // 如果服务端返回了错误信息则使用服务端的错误信息
    // console.log(error.response.data)
    if (error.response && error.response.data && error.response.data.message) {
      console.log(error.response.data)
      errMessage = error.response.data.message
    }
    Message({
        message: errMessage,
        type: 'error',
        duration: 3 * 1000
      })
    return Promise.reject(error)
  }
)

export default service
