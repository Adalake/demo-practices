<template>
  <div id="app">
    <div class="top">
      <!-- <img alt="Vue logo" src="./assets/logo.png" /> -->
      <HelloWorld msg="Welcome to Your Vue.js App" />
      <router-link to="/test">Go to Foo</router-link>
      <router-link to="/home">Go to Home</router-link>
      <router-link to="/product">Go to product</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";

export default {
  name: "App",
  components: {
    HelloWorld // es6中如果键和值一样，只写一个
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
.top {
  /* 弹性盒子 */
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-between;
}
</style>
