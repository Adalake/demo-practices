<template>
  <div>
    about1111
    <button @click="set1">存 1</button>
    <button @click="set2">存 2</button>
    <button @click="get1">取 1</button>
    <button @click="delete1">删除缓存</button>
  </div>
</template>

<script>
export default {
  name: "about",
  data() {
    return {
      list: [],
    };
  },
  methods: {
    set1() {
      var value = {
        room: "room1",
        time: 40,
      };
      var getInit = JSON.parse(window.localStorage.getItem("allList"));
      if (getInit === null) {
        var arr = [];
        arr.push(value);
        var initValue2 = JSON.stringify(arr);
        console.log(initValue2);
        window.localStorage.setItem("allList", initValue2);
      } else {
        console.log(1);
        //先判断有没有
        var hasLog = getInit.find((item) => {
          return item.room === "room1"; //当前的room名字
        });
        if (hasLog !== undefined) {
          getInit.splice(getInit.indexOf(hasLog), 1);
          console.log(2, getInit);
        }
        //没有就存入
        var tempInitValue2 = [...getInit, value];
        initValue2 = JSON.stringify(tempInitValue2);
        console.log(3, initValue2);
        window.localStorage.setItem("allList", initValue2);
      }
      // console.log(window.localStorage.getItem("allList"));
    },
    set2() {
      var value = {
        room: "room2",
        time: 99,
      };
      var getInit = JSON.parse(window.localStorage.getItem("allList"));
      if (getInit === null) {
        var arr = [];
        arr.push(value);
        var initValue2 = JSON.stringify(arr);
        console.log(initValue2);
        window.localStorage.setItem("allList", initValue2);
      } else {
        //先判断有没有
        var hasLog = getInit.find((item) => {
          return item.room === "room2"; //当前的room名字
        });
        if (hasLog !== undefined) {
          getInit.splice(getInit.indexOf(hasLog), 1);
        }
        //没有就存入
        var tempInitValue2 = [...getInit, value];
        initValue2 = JSON.stringify(tempInitValue2);
        window.localStorage.setItem("allList", initValue2);
      }
      // console.log(window.localStorage.getItem("allList"));
    },
    get1() {
      var tempAllList = window.localStorage.getItem("allList");
      var allList = JSON.parse(tempAllList);
      console.log(allList);
    },
    delete1() {
      window.localStorage.removeItem("allList");
      console.log(window.localStorage.getItem("allList"));
    },
  },
};
</script>

<style scoped>
</style>