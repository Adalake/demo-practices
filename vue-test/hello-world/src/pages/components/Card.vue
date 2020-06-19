<template>
  <div class="child">
    <h3>这里是子组件</h3>
    <slot></slot>
    <slot name="up"></slot>
    {{ info }}
    <p>加了过滤器：</p>
    <input v-model="message" />
    {{ message | capitalize }}
    <h1>Bitcoin Price Index</h1>
    <section v-if="errored">
      <p>We're sorry, we're not able to retrieve this information at the moment, please try back later</p>
    </section>
    <section v-else>
      <div v-if="loading">Loading...</div>
      <div v-else v-for="currency in info" :key="currency" class="currency">
        {{ currency.description }}:
        <span>
          <span v-html="currency.symbol"></span>
          {{ currency.rate_float | currencydecimal }}
        </span>
      </div>
    </section>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Card",
  data() {
    return {
      info: null,
      loading: true,
      errored: false,
      message: null
    };
  },
  filters: {
    currencydecimal(value) {
      return value.toFixed(2);
    },
    capitalize: function(value) {
      if (!value) return "";
      value = value.toString();
      return value.toUpperCase();
    }
  },
  mounted() {
    axios
      .get("https://api.coindesk.com/v1/bpi/currentprice.json")
      .then(response => (this.info = response.data.bpi))
      .catch(error => console.log(error))
      .finally(() => (this.loading = false));
  }
};
</script>

<style scoped>
</style>