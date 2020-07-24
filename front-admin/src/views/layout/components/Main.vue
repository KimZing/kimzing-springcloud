<template>
  <section>
    <transition name="fade" mode="out-in">
      <router-view></router-view>
    </transition>
  </section>
</template>

<script>

</script>

<style scoped>
  /*fade*/
  .fade-enter-active,
  .fade-leave-active {
    transition: opacity 0.28s;
  }

  .fade-enter,
  .fade-leave-active {
    opacity: 0;
  }

  /*fade*/
  .breadcrumb-enter-active,
  .breadcrumb-leave-active {
    transition: all .5s;
  }
</style>