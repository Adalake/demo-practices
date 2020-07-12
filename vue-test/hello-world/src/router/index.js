import Vue from "vue";
import Router from "vue-router";
import Test from "../components/Test.vue";
import Home from "../pages/Home.vue";
import Product from "../pages/components/Product.vue";
import Send from "../pages/components/Send.vue";

// Vue.use(Router);
if (!window.VueRouter) Vue.use(Router);

const main = () => import("@/views/Main");
import home from "@/views/home";
import about from "@/views/about";

const routes = [
  {
    path: "/main",
    component: main,
  },
  {
    path: "/home",
    component: home,
  },
  {
    path: "/about",
    component: about,
  },
  {
    path: "/test",
    name: "Test", // name the route
    component: Test,
  },
  {
    path: "/home",
    name: "Home",
    component: Home,
  },
  {
    path: "/product",
    name: "Product",
    component: Product,
  },
  {
    path: "/send",
    name: "Send",
    component: Send,
  },
];
export default new Router({
  mode: "history", // 不然就会有个#
  routes: routes,
});
