<template>
  <div>
    <i :class="sidebar.opened ? 'el-icon-s-unfold' : 'el-icon-s-fold'"
       @click="toggleSideBar"></i>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>活动管理</el-breadcrumb-item>
      <el-breadcrumb-item>活动列表</el-breadcrumb-item>
      <el-breadcrumb-item>活动详情</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
  import {mapGetters} from 'vuex'

  export default {
    data() {
      return {}
    },
    computed: {
      ...mapGetters([
        'sidebar',
      ])
    },
    methods: {
      toggleSideBar() {
        this.$store.dispatch('ToggleSideBar')
      },
    }
  }
</script>

<style scoped>
  /*导航栏展开关闭按钮图标样式*/
  .el-icon-s-fold, .el-icon-s-unfold {
    float: left;
    font-size: 26px;
    margin-top: 10px;
  }

  /*面包屑*/
  .el-breadcrumb {
    float: left;
    font-size: 16px;
    margin-top: 15px;
    margin-left: 15px;
  }
</style>