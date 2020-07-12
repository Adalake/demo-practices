import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import Vuex from "vuex";
import store from "./store";
import axios from "axios";
import websocket from "./store/modules/websocket";
import {
  Button,
  Select,
  Tabs,
  TabPane,
  Menu,
  MenuItem,
  Submenu,
  Pagination,
  Table,
  TableColumn,
} from "element-ui";

Vue.use(Vuex); // 引入vuex

Vue.config.productionTip = false;
Vue.prototype.axios = axios;
Vue.prototype.$websocket = websocket;
Vue.use(Button);
Vue.use(Select);
Vue.use(Tabs);
Vue.use(TabPane);
Vue.use(Menu);
Vue.use(MenuItem);
Vue.use(Submenu);
Vue.use(Pagination);
Vue.use(Table);
Vue.use(TableColumn);

new Vue({
  el: "#app",
  router,
  store, // 引入vuex
  component: { App },
  template: "<App/>",
  render: (h) => h(App),
});
