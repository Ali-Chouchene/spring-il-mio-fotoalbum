import { createRouter, createWebHistory } from 'vue-router'
// import HomeView from '../views/HomeView.vue'
import FotoIndex from '../views/FotoIndex.vue'
import MexApp from '../views/MexApp.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: '',
      component: FotoIndex
    },
    {
      path: '/messaggio',
      name: 'messaggio',
      component: MexApp
    }
  ]
})

export default router
