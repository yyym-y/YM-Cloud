import Vue from 'vue'
import App from './App.vue'
import store from './store'
import Particles from 'particlesjs'
import axios from 'axios'
Vue.prototype.$axios = axios

Vue.config.productionTip = false


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
  render: h => h(App)
}).$mount('#app')
