import Test from '../components/Test.vue';
import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "Test",
      component: Test
    },
  ],
});
