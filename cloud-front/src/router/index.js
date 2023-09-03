import Vue from 'vue'
import Log from '@/views/Log-view'
import Main from '@/views/Main-view'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = new VueRouter({
    routes : [
        {path: '/', redirect: '/LogIn'},
        {path: '/LogIn', component : Log},
        {path: '/Discovery', component : Main}
    ]
})

export default routes
