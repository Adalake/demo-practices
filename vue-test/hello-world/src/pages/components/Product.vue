<template>
  <div>
    计数器：
    <p>{{ $store.state.count.count }}</p>
    <div>
      <button @click="$store.commit('increment')">+</button>
      <button @click="$store.commit('decrement')">-</button>
    </div>
    <product-list-one v-bind:products="products"></product-list-one>
    <product-list-two v-bind:products="products"></product-list-two>
  </div>
</template>

<script>
import ProductListOne from "./ProductListOne";
import ProductListTwo from "./ProductListTwo";

export default {
  name: "Product",
  components: {
    "product-list-one": ProductListOne,
    "product-list-two": ProductListTwo
  },
  data() {
    return {
      products: [
        { name: "鼠标", price: 20 },
        { name: "键盘", price: 40 },
        { name: "耳机", price: 60 },
        { name: "显示屏", price: 80 }
      ]
    };
  },
  created: function() {
    this.axios.get("api/seller").then(
      res => {
        console.log(res);
      },
      function(err) {
        console.log(err);
      }
    );
  }
};
</script>

<style scoped>
</style>