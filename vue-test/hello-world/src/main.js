import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import Vuex from "vuex";
import store from "./store";
import axios from "axios";
// import VueSocketIO from "vue-socket.io";
import websocket from "./store/modules/websocket";
Vue.use(Vuex); // 引入vuex

// Vue.use(
//   new VueSocketIO({
//     debug: true,
//     // 服务器端地址
//     connection: "http://localhost:3000",
//     vuex: {},
//   })
// );

// import { Button } from "ant-design-vue";
// import 'ant-design-vue/lib/button/style/css'
// Vue.component(Button.name, Button)

Vue.config.productionTip = false;
Vue.prototype.axios = axios;
Vue.prototype.$websocket = websocket;

// new Vue({
//   render: (h) => h(App),
// }).$mount("#app");

new Vue({
  el: "#app",
  router,
  store, // 引入vuex
  component: { App },
  template: "<App/>",
  render: (h) => h(App),
});
