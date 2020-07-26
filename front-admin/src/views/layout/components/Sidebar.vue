<template>
  <el-menu default-active="1" class="el-menu-vertical"
           :style="{'height': height}"
           :collapse="isCollapse"
           :router="true"
           background-color="#304156"
           text-color="#BFCBD9"
           active-text-color="#409EFF">
    <el-menu-item index="home">
      <i class="el-icon-s-home"></i>
      <span slot="title">首页</span>
    </el-menu-item>
    <el-submenu index="product">
      <template slot="title">
        <i class="el-icon-s-goods"></i>
        <span slot="title">产品管理</span>
      </template>
      <el-menu-item index="productList">
        <i class="el-icon-s-grid"></i>
        <span slot="title">产品列表</span>
      </el-menu-item>
      <el-menu-item index="addProduct">
        <i class="el-icon-circle-plus"></i>
        <span slot="title">添加产品</span>
      </el-menu-item>
    </el-submenu>
    <el-submenu index="order">
      <template slot="title">
        <i class="el-icon-s-order"></i>
        <span slot="title">订单管理</span>
      </template>
      <el-menu-item index="orderList">
        <i class="el-icon-s-grid"></i>
        <span slot="title">订单列表</span>
      </el-menu-item>
    </el-submenu>
    <el-submenu index="security">
      <template slot="title">
        <i class="el-icon-lock"></i>
        <span slot="title">权限管理</span>
      </template>
      <el-menu-item index="adminList">
        <i class="el-icon-user-solid"></i>
        <span slot="title">用户列表</span>
      </el-menu-item>
      <el-menu-item index="roleList">
        <i class="el-icon-key"></i>
        <span slot="title">角色列表</span>
      </el-menu-item>
      <el-menu-item index="menuList">
        <i class="el-icon-view"></i>
        <span slot="title">菜单列表</span>
      </el-menu-item>
      <el-menu-item index="resourceList">
        <i class="el-icon-aim"></i>
        <span slot="title">资源列表</span>
      </el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<script>
  import {mapGetters} from 'vuex'

  export default {
    data() {
      return {
        // 侧边栏展开收起状态及其样式配置
        height: window.innerHeight + 'px',
      }
    },
    computed: {
      ...mapGetters([
        'sidebar',
      ]),
      isCollapse() {
        return this.sidebar.opened
      }
    },
    created() {
      this.setSize()
      // 注册窗口调整事件
      window.addEventListener('resize', this.setSize);
    },
    methods: {
      // 获取当前浏览器窗口大小
      setSize() {
        if (this.timer) {
          return
        }
        this.timer = true
        let that = this
        setTimeout(function () {
          that.timer = false
          that.height = window.innerHeight + 'px';
        }, 500)
      }
    }
  }
</script>

<style scoped>
  .el-menu-vertical i {
    font-size: 20px;
  }

  .el-menu-vertical span {
    margin-left: 12px;
  }

  /*菜单栏展开*/
  .el-menu-vertical:not(.el-menu--collapse) {
    width: 200px;
  }
</style>