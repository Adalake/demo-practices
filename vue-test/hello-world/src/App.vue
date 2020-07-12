<template>
  <div id="app">
    <div class="top">
      <HelloWorld msg="Welcome to Your Vue.js App" />
      <!-- <router-link to="/test">Go to Foo</router-link>
      <router-link to="/home">Go to Home</router-link>-->
      <router-link to="/product">Go to product</router-link>
      <!-- <router-link to="/send">Go to send</router-link> -->
      <router-link to="/main">
        <!-- <mainCourse></mainCourse> -->to main
      </router-link>
    </div>
    <div class="middle">
      <keep-alive>
        <router-view></router-view>
      </keep-alive>
    </div>
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";
// import main from "@/views/main";
export default {
  name: "App",
  components: {
    HelloWorld, // es6中如果键和值一样，只写一个
    // mainCourse: main
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
