<template>
  <div>
    <el-container>
      <el-aside :width="'auto'">
        <el-menu default-active="1" class="el-menu-vertical" @open="handleOpen" @close="handleClose"
                 :style="{'height': navMenu.height}"
                 :background-color="navMenu.backgroundColor"
                 :text-color="navMenu.textColor"
                 :active-text-color="navMenu.activeTextColor"
                 :collapse="navMenu.isCollapse">
          <el-menu-item index="1">
            <i class="el-icon-s-home"></i>
            <span slot="title">首页</span>
          </el-menu-item>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-s-goods"></i>
              <span slot="title">商品管理</span>
            </template>
            <el-menu-item index="1-1">
              <i class="el-icon-s-grid"></i>
              <span slot="title">商品列表</span>
            </el-menu-item>
            <el-menu-item index="1-2">
              <i class="el-icon-circle-plus"></i>
              <span slot="title">添加商品</span>
            </el-menu-item>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-s-order"></i>
              <span slot="title">订单管理</span>
            </template>
            <el-menu-item index="3-1">
              <i class="el-icon-s-grid"></i>
              <span slot="title">订单列表</span>
            </el-menu-item>
          </el-submenu>
          <el-submenu index="4">
            <template slot="title">
              <i class="el-icon-lock"></i>
              <span slot="title">权限管理</span>
            </template>
            <el-menu-item index="4-1">
              <i class="el-icon-user-solid"></i>
              <span slot="title">用户列表</span>
            </el-menu-item>
            <el-menu-item index="4-2">
              <i class="el-icon-key"></i>
              <span slot="title">角色列表</span>
            </el-menu-item>
            <el-menu-item index="4-3">
              <i class="el-icon-view"></i>
              <span slot="title">菜单列表</span>
            </el-menu-item>
            <el-menu-item index="4-4">
              <i class="el-icon-aim"></i>
              <span slot="title">资源列表</span>
            </el-menu-item>
          </el-submenu>

        </el-menu>
      </el-aside>
      <el-container>
        <el-header>
          <i :class="navMenu.isCollapse ? 'el-icon-s-unfold' : 'el-icon-s-fold'"
             @click="navMenu.isCollapse=!navMenu.isCollapse"></i>
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>活动管理</el-breadcrumb-item>
            <el-breadcrumb-item>活动列表</el-breadcrumb-item>
            <el-breadcrumb-item>活动详情</el-breadcrumb-item>
          </el-breadcrumb>
        </el-header>
        <el-main>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        // 侧边栏展开收起状态及其样式配置
        navMenu: {
          isCollapse: false,
          height: window.innerHeight + 'px',
          textColor: "#BFCBD9",
          backgroundColor: "#304156",
          activeTextColor: "#409EFF",
        }
      }
    },
    created() {
      this.setSize()
      window.addEventListener('resize', this.setSize);
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      // 获取当前浏览器窗口大小
      setSize() {
        if (this.timer) {
          return
        }
        this.timer = true
        let that = this
        setTimeout(function () {
          that.timer = false
          that.navMenu.height = window.innerHeight + 'px';
        }, 500)
      }
    }
  }

</script>

<style scoped>
  /*面包屑*/
  .el-header .el-breadcrumb {
    float: left;
    font-size: 16px;
    margin-top: 15px;
    margin-right: 10px;
    margin-left: 15px;
  }

  /*导航栏展开关闭按钮图标样式*/
  .el-icon-s-fold, .el-icon-s-unfold {
    float: left;
    font-size: 26px;
    margin-top: 10px;
  }

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
