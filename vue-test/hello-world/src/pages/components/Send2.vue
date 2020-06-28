<template>
  <div @click="clickAction">send2</div>
</template>

<script>
export default {
  name: "Send2",
  data() {
    return {
      //   receive: receive
    };
  },
  mounted() {
    // console.log("初始化send2");
    // this.$socket.on("relogin", data => {
    //   console.log(data);
    // });
  },
  methods: {
    clickAction() {
      this.$socket.emit("login", {
        username: "username111",
        password: "password"
      });
    }
  }
};
</script>

<style scoped>
</style>