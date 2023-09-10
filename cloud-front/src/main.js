import Vue from 'vue'
import App from './App.vue'
import store from './store'
import Particles from 'particlesjs'
import axios from 'axios'
Vue.prototype.$axios = axios
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false
Vue.use(ElementUI);

window.onload = function() {
  Particles.init({
    selector: '.background',
    connectParticles : true,
    speed : 1,
    minDistance : 100
  });
};

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
