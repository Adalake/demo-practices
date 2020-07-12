<template>
  <div>
    <ul>
      <li @click="tabChange('home')">首页</li>
      <li @click="tabChange('about')">关于我们</li>
    </ul>
    <keep-alive>
      <!-- <router-view></router-view> -->
      <component :is="currView"></component>
    </keep-alive>
  </div>
</template>


<script>
export default {
  data() {
    return {
      currView: "about"
    };
  },
  methods: {
    tabChange(v) {
      console.log(v);
      // this.$router.push(`${v}`)
    }
  }
};
</script>

<style scoped>
</style> 