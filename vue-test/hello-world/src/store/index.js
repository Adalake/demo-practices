import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);
import count_store from "./modules/count_store.js";

export default new Vuex.Store({
  state: {
    products: [
      { name: "鼠标", price: 20 },
      { name: "键盘", price: 40 },
      { name: "耳机", price: 60 },
      { name: "显示屏", price: 80 },
    ],
  },
  getters: {
    //添加getters
    saleProducts: (state) => {
      let saleProducts = state.products.map((product) => {
        return {
          name: product.name,
          price: product.price / 2,
        };
      });
      return saleProducts;
    },
  },
  mutations: {
    //添加mutations
    minusPrice(state, payload) {
      state.products.forEach((product) => {
        product.price -= payload;
      });
    },
  },
  actions: {
    //添加actions
    minusPriceAsync(context, payload) {
      setTimeout(() => {
        context.commit("minusPrice", payload); //context提交
      }, 2000);
    },
  },
  modules: {
    count: count_store, // 分割为模块
  },
});
// 当应用比较简单时，可以把状态都写在一个store对象index.js里，
// 但当应用变得非常复杂时，index.js就有可能很臃肿。
// 所以我们将 store 分割成模块（module）
