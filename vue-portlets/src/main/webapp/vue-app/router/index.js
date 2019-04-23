import Vue from 'vue'
import Router from 'vue-router'
import IdeaDrafted from '../components/IdeaDrafted.vue'
import IdeaFav from '../components/IdeaFav.vue'
import IdeaPublished from '../components/IdeaPublished.vue'
import IdeaInfo from '../components/IdeaInfo.vue'
import IdeaArchived from '../components/IdeaArchived.vue'
import test from '../components/test.vue';


Vue.use(Router)

export default new Router({
  routes: [
  
      {
        path: '/ideadrafted',
        name: 'IdeaDrafted',
        component: IdeaDrafted
      },
    
      {
        path: '/ideafav',
        name: 'IdeaFav',
        component: IdeaFav
      },
      {
        path: '/',
        name: 'IdeaPublished',
        component: IdeaPublished
      },
      
      {
        path: '/ideainfo',
        name: 'IdeaInfo',
        component: IdeaInfo
      },
      {
        path: '/ideaarchived',
        name: 'IdeaArchived',
        component: IdeaArchived
      }, 
      {
        path: '/test',
        name: 'test',
        component: test
      }


  ]
  
})
