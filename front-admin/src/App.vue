<template>
  <div id="app">
    <Main/>
  </div>
</template>

<script>
  import Main from './components/Main.vue'

  export default {
    name: 'App',
    components: {
      Main
    }
  }
</script>

<style>
  body {
    /*去除与浏览器的空白边距*/
    padding: 0px;
    margin: 0px;
    height: 100%;
  }

  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    /*抗锯齿*/
    -webkit-font-smoothing: antialiased; /*chrome、safari*/
    -moz-osx-font-smoothing: grayscale; /*firefox*/
  }

</style>
