// 创建新的 axios对象
import axios from 'axios';

const _axios = axios.create({
  // baseURL: import.meta.env.VITE_BACKEND_API_BASE_URL
})

// 请求拦截器
_axios.interceptors.request.use(
  (config) => { // 统一添加请求头
    if (config && config.headers) { // 多一步判断
      config.headers['Authorization'] = 'aaa.bbb.ccc'
    }
    return config
  },
  (error) => { // 请求出错时的处理
    return Promise.reject(error)
  }
)


export default _axios;