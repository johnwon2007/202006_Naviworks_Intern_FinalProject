import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';
import vuetify from './plugins/vuetify';
import RestaurantCreate from "./views/RestaurantCreate.vue";
import RestaurantView from "./views/RestaurantView.vue";

//Vue.prototype.$axios = axios;
Vue.config.productionTip = false

Vue.use(VueRouter);//router기능 확장 선언

//여기에 라우터 등록
const routes = [
  {
    path: '/',
    component: RestaurantView
  },
  {
    path : '/add',
    component: RestaurantCreate
  }
];

//router 객체생성
const router = new VueRouter({
  routes
});

new Vue({
  vuetify,
  render: h => h(App),
  router
}).$mount('#app')
