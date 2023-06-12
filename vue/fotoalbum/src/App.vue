<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HeaderApp from './components/HeaderApp.vue'
import AppJumbo from './components/AppJumbo.vue'
</script>

<template>
  <HeaderApp />
  <AppJumbo />
  <RouterView />
</template>

<style>
@import url(../node_modules/bootstrap);
</style>
