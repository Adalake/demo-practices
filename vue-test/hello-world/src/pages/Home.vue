<template>
  <div class="home">
    <home-header testInput="vue父组件向子组件传递数据 by props" @clickHeadAction="clickChild"></home-header>我是Home
  </div>
</template>

<script>
import HomeHeader from "./components/Header";

export default {
  name: "Home",
  components: {
    HomeHeader: HomeHeader
  },
  methods: {
    clickChild(msg) {
      console.log(msg);
    }
  }
};
</script>

<style scoped>
.home {
  border: 1px solid green;
}
</style> 