<template>
  <div class="bottom-test">
    <div class="test">2332</div>
    <div class="fxLayoutBox">
      <div class="fxLayoutItem">1</div>
      <div class="fxLayoutItem">1</div>
      <div class="fxLayoutItem">1</div>
      <div class="fxLayoutItem">1</div>
      <div class="fxLayoutItem">1</div>
      <div class="fxLayoutItem">1</div>
      <div class="fxLayoutItem">1</div>
      <div class="fxLayoutItem">1</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Test"
};
</script>

<style scoped>
.test {
  color: red;
  border: 1px solid red;
}
.fxLayoutBox {
  display: flex;
  display: -webkit-flex; /* Safari */
  flex: auto;
  align-items: center; /*纵轴*/
  -webkit-align-items: center;
  flex-direction: column;
  justify-content: center; /*水平轴*/
}
.fxLayoutItem {
  width: 60px;
  min-height: 20px;
  margin: auto;
  align-self: stretch;
  flex: auto;
}
.bottom-test {
  display: flex;
  flex-direction: column;
  flex: auto;
}
</style>