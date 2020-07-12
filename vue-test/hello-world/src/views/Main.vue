<template>
  <div>
    <h1>main component</h1>
    <el-button type="primary" icon="el-icon-arrow-left">上一页</el-button>
    <!-- <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="用户管理" name="first">用户管理</el-tab-pane>
      <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane>
      <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
      <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>
    </el-tabs>-->
    <router-link to="/main/home">home1</router-link>
    <router-link to="/main/about">home2</router-link>
    <!--  -->
    <el-menu router :default-active="defaultActive" mode="horizontal">
      {{defaultActive}}
      <el-menu-item index="/main/home">用户列表</el-menu-item>
      <el-menu-item index="/main/about">商家列表</el-menu-item>
      <el-menu-item index="/main/menu">主页</el-menu-item>
    </el-menu>
    <!--  -->
    <keep-alive>
      <router-view></router-view>
    </keep-alive>
  </div>
</template>


<script>
export default {
  data() {
    return {
      active: "main",
      defaultActive: "menu",
      tabbar: [
        {
          name: "about"
        },
        {
          name: "home"
        },
        {
          name: "main"
        }
      ],
      activeName: "second"
    };
  },
  watch: {
    // $route: "changeActive"
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    tabChange(name) {
      console.log(name);
      this.$router.replace({ path: `main/${name}` });
    },
    changeActive({ name }) {
      this.setActive(name);
    },
    setActive(name) {
      this.tabbar.forEach((tab, i) => {
        if (tab.name == name) {
          this.active = i;
          return false;
        }
      });
    }
  }
};
</script>

<style scoped>
.van-button--primary {
  font-size: 20px;
  background-color: pink;
}
</style> 