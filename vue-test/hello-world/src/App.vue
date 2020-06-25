<template>
  <div id="app">
    <div class="top">
      <!-- <img alt="Vue logo" src="./assets/logo.png" /> -->
      <HelloWorld msg="Welcome to Your Vue.js App" />
      <router-link to="/test">Go to Foo</router-link>
      <router-link to="/home">Go to Home</router-link>
      <router-link to="/product">Go to product</router-link>
    </div>
    <div class="middle">
      <div class="left">left</div>
      <div class="right">
        <div>right1</div>
        <div>right2</div>
      </div>
    </div>
    <div class="center-box">
      <div class="center-item"></div>
    </div>
    <div class="bottom">
      <router-view></router-view>
    </div>
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
  /* 撑满 */
  display: flex;
  flex-direction: column;
  align-content: center;
  min-height: 100vh;
}
.top {
  /* 弹性盒子 */
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-between;
  height: 100px;
}
.middle {
  /* height: 40px; */
  /* test */
  flex: auto;
  display: flex;
}
.left {
  width: 200px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.right {
  flex: auto;
  display: flex;
  flex-direction: column;
  /* 以下注意，这样子元素会在right的右侧，上下两边排布 */
  justify-content: space-between;
  align-items: flex-end;
  /* 如果是row方向，那么子元素会在right的下侧，左右两边排布 */
}
.bottom {
  /* flex: auto; */
  height: 1000px;
  /* 以下，让子容器撑满 */
  align-items: stretch;
  display: flex;
  flex-direction: column;
}
.center-box {
   height: 40px;
   display: -webkit-flex;
}
.center-item {
  width: 20px;
  height: 20px;
  background-color: goldenrod;
  margin: auto;
}
</style>
