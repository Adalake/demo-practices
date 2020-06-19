import Vue from "vue";
import Router from "vue-router";
import Test from "../components/Test.vue";
import Home from "../pages/Home.vue";
import Product from "../pages/components/Product.vue";
Vue.use(Router);

const routes = [
  {
    path: "/test",
    component: Test,
  },
  {
    path: "/home",
    component: Home,
  },
  {
    path: "/product",
    component: Product,
  },
];
export default new Router({
  routes: routes,
});
