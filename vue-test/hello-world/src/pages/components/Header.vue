 <template>
  <div>
    <div @click="clickAction">按钮{{dataTest1}}</div>
    <div @click="clickTest">按钮2</div>
    <div class="homeHeader">我是HomeHeader+{{testInput}}</div>
    <img :src="url" />用:src=“url"
    <div class="buttons">
      以下测试了对v-bind:class的几种使用，样式的绑定方法：
      <button :class="classObject">Button1</button>
      <button :class="{textSize:isSizeLarge}">Button2</button>
      <button :class="isSizeLarge?'textSize':''">Button3</button>
      <button :class="[isSizeLarge?'textSize':'','textColor']">Button4</button>
    </div>
    <div class="buttons">
      以下测试了对v-bind:style的几种使用，样式的绑定方法：
      <button :style="styleObject">Button5</button>
      <button :style="[styleObject,styleObjec2]">Button6</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeHeader",
  props: {
    testInput: String
  },
  methods: {
    clickTest() {
      console.log("click");
    },
    clickAction() {
      this.$emit("clickHeadAction", "子组件向父组件传值 by $emit");
    }
  },
  data() {
    return {
      dataTest1: "dataTest1",
      classObject: {
        textColor: true,
        textSize: false
      },
      isSizeLarge: true,
      styleObject: {
        color: "blue",
        fontSize: "30px"
      },
      styleObjec2: {
        textDecoration: "underline"
      },
      url:
        "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png"
    };
  },
  created() {
    console.log("初始化");
  }
};
</script>

<style scoped>
.homeHeader {
  border: 1px solid fuchsia;
}
.textColor {
  color: #f00;
  background-color: #eef;
}
.textSize {
  font-size: 30px;
  font-weight: bold;
}
.buttons {
  display: -webkit-flex; /* Safari */
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
</style> 