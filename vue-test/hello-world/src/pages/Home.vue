<template>
  <div class="home">
    <home-header testInput="vue父组件向子组件传递数据 by props" @clickHeadAction="clickChild"></home-header>
    <Main></Main>
   </div>
</template>

<script>
import HomeHeader from "./components/Header";
import Main from "./components/Main";

export default {
  name: "Home",
  components: {
    HomeHeader: HomeHeader,
    Main
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
  display: flex;
  flex-direction: row;
}
</style> 