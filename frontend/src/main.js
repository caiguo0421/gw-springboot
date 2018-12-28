// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import App from './App'
import router from './router'
import Vue from 'vue'
import Vuetify from 'vuetify'
// 引入vuetify的css
import 'vuetify/dist/vuetify.min.css'
// 引入Material Design图标
import 'material-design-icons-iconfont/dist/material-design-icons.css'
// 安装babel支持IE11和Safari 9
import 'babel-polyfill'
// Translation provided by Vuetify (javascript)
import zhHans from 'vuetify/lib/locale/zh-Hans'

Vue.use(Vuetify, {
  lang: {
    locales: { 'zh-Hans': zhHans },
    current: 'zh-Hans'
  }
})

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
