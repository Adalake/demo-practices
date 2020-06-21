import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import Vuex from "vuex";
import store from "./store";
import axios from "axios";

Vue.use(Vuex); // 引入vuex
// import { Button } from "ant-design-vue";
// import 'ant-design-vue/lib/button/style/css'
// Vue.component(Button.name, Button)

Vue.config.productionTip = false;
Vue.prototype.axios = axios;

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
