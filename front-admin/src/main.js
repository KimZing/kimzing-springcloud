import Vue from 'vue'
import App from './App.vue'
// 路由配置
import router from './router/router'
// elementui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 全局CSS样式
import '@/styles/index.scss'

Vue.use(ElementUI);

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
