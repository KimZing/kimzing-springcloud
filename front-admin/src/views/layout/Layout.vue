<template>
  <div>
    <el-container>
      <!--   设置为auto，根据内容进行动态改变   -->
      <el-aside :width="'auto'">
        <Sidebar></Sidebar>
      </el-aside>
      <el-container>
        <el-header>
          <Navbar></Navbar>
        </el-header>
        <el-main>
          <Main></Main>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  import {Sidebar, Navbar, Main} from "./components";

  export default {
    data() {
      return {
      }
    },
    components: {
      Sidebar,
      Navbar,
      Main,
    },
    created() {
    },
    methods: {
    }
  }

</script>

<style scoped>

</style>
