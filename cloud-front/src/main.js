import Vue from 'vue'
import App from './App.vue'
import store from './store'
// import Particles from 'particlesjs'

Vue.config.productionTip = false


// window.onload = function() {
//   Particles.init({
//     selector: '.background',
//     connectParticles : true,
//     speed : 0.8,
//     minDistance : 130
//   });
// };

new Vue({
  store,
  render: h => h(App)
}).$mount('#app')
