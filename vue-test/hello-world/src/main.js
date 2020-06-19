import Vue from "vue";
import App from "./App.vue";
import router from "./router";

// import { Button } from "ant-design-vue";
// import 'ant-design-vue/lib/button/style/css'
// Vue.component(Button.name, Button)

Vue.config.productionTip = false;

// new Vue({
//   render: (h) => h(App),
// }).$mount("#app");

new Vue({
  el: "#app",
  router,
  component: { App },
  template: "<App/>",
  render: (h) => h(App),
});
