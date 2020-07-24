import Vue from "vue";
import Router from "vue-router";
import Main from '../views/layout/Layout'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      component: Main
    },
  ]
})