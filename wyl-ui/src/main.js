import Vue from 'vue'

import 'normalize.css/normalize.css' // A modern alternative to CSS resets

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// import locale from 'element-ui/lib/locale/lang/en' // 英文
import locale from 'element-ui/lib/locale/lang/zh-CN' // 中文

import '@/styles/index.scss' // global css
import '@/assets/styles/common.scss' // common css

import App from './App'
import store from './store'
import router from './router'
import plugins from './plugins' // plugins

import '@/icons' // icon
import '@/permission' // permission control

import {download} from '@/utils/request'

// 重置表单
import {parseTime, resetForm, addDateRange} from "@/utils/common";
// 分页组件
import Pagination from "@/components/Pagination";
// 字典数据组件
import DictData from '@/components/DictData'
// 字典标签组件
import DictTag from '@/components/DictTag'
// 自定义表格工具组件
import RightToolbar from "@/components/RightToolbar"

// 全局方法挂载
Vue.prototype.parseTime = parseTime
Vue.prototype.resetForm = resetForm
Vue.prototype.addDateRange = addDateRange
Vue.prototype.download = download

// 全局组件挂载
// 分页组件
Vue.component('DictTag', DictTag)
Vue.component('Pagination', Pagination)
Vue.component('RightToolbar', RightToolbar)

Vue.use(plugins)
DictData.install()

/**
 * If you don't want to use mock-server
 * you want to use MockJs for mock api
 * you can execute: mockXHR()
 *
 * Currently MockJs will be used in the production environment,
 * please remove it before going online ! ! !
 */
if (process.env.NODE_ENV === 'production') {
  const {mockXHR} = require('../mock')
  mockXHR()
}

// set ElementUI lang to EN
Vue.use(ElementUI, {locale})
// 如果想要中文版 element-ui，按如下方式声明
// Vue.use(ElementUI)

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
