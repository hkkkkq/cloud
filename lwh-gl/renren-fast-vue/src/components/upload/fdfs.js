import Vue from 'vue'
import axios from 'axios'
import router from '@/router'
import { clearLoginInfo } from '@/utils'

const instance = axios.create({
  timeout: 1000 * 30,
  withCredentials: true,
  // headers: {
  //   'Content-Type':'multipart/form-data;'
  // },
  headers:{"Content-Type":"multipart/form-data;boundary="+new Date().getTime()}

})

instance.interceptors.request.use(config => {
  config.headers['token'] = Vue.cookie.get('token') // 请求头带上token
  console.warn("config",config.headers)
  return config
}, error => {
  return Promise.reject(error)
})

/**
 * 上传文件
 * @param file
 * @returns {FormData}
 */
instance.fileUpload =(file)=>{
  let param = new FormData();
  param.append('file',file);
  return param;
}

/**
 * 响应拦截
 */
instance.interceptors.response.use(response => {
  if (response.data && response.data.code === 401) { // 401, token失效
    clearLoginInfo()
    router.push({ name: 'login' })
  }
  return response
}, error => {
  return Promise.reject(error)
})

export function fdfs(fd) {
   return  new Promise((resolve,reject)=>{
     instance({
            url: window.SITE_CONFIG.baseUrl+'/thirdparty/fdfs/upload',
            method: "post",
            data: fd,
            params: instance.fileUpload(fd.file)
        }).then(({ data }) => {
            resolve(data);
        })
    });
}
