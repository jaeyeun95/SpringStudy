import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
// import {URL} from '@/apis/http.js';
// axios.defaults.baseURL = URL;

Vue.prototype.$axios = axios;
// axios.defaults.baseURL = "http://localhost:9999";

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
