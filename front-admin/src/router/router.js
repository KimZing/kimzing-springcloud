import Vue from "vue";
import Router from "vue-router";
import Home from "../views/home/index"
import Layout from "../views/layout/Layout"
import ProductIndex from "../views/product/index"
import AddProduct from "../views/product/add"
import OrderIndex from "../views/order/index"
import AdminIndex from "../views/security/admin"
import RoleIndex from "../views/security/role"
import MenuIndex from "../views/security/menu"
import ResourceIndex from "../views/security/resource"

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      component: Layout,
      redirect: "/home",
      children: [
        // 首页
        {
          path: "home",
          component: Home
        },
        // 商品列表
        {
          path: "productList",
          component: ProductIndex
        },
        // 添加商品
        {
          path: "addProduct",
          component: AddProduct
        },
        // 订单列表
        {
          path: "orderList",
          component: OrderIndex
        },
        // 用户列表
        {
          path: "adminList",
          component: AdminIndex
        },
        // 角色列表
        {
          path: "roleList",
          component: RoleIndex
        },
        // 菜单列表
        {
          path: "menuList",
          component: MenuIndex
        },
        // 资源列表
        {
          path: "resourceList",
          component: ResourceIndex
        },
      ]
    },
  ]
})