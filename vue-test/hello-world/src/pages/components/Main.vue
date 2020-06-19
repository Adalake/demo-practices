<template>
  <div>
    <div class="main">main component:</div>
    <p>{{ reversedMessage }}</p>
    <div v-for="item in items" :key="item.mes">{{ item.mes }}</div>
    <input v-model="inputMes" />
    {{inputMes}}
    <Card>
      <span>菜单1 {{inputMes}}</span>
    </Card>
    <Card>
      <div slot="up">
        <span>具名 菜单1</span>
        <span>具名 菜单2</span>
      </div>
    </Card>
  </div>
</template>

<script>
import Card from "./Card";

export default {
  name: "Main",
  components: {
    Card
  },
  data() {
    return {
      message: "Hello",
      items: [
        {
          mes: "111"
        },
        {
          mes: "222"
        }
      ],
      inputMes: "inputMes",
      
    };
  },
  computed: {
    reversedMessage() {
      return this.message;
    }
  }
};
</script>

<style scoped>
.main {
  border: grey 1px solid;
}
body {
  font-family: Ubuntu;
  color: #555;
}
</style>