import Vue from 'vue';
import IdeaApp from './components/IdeaApp.vue';
import router from './router/index';
import '../css/main.less';

Vue.use(Vuetify);

const vueInstance = new Vue({
  el: '#IdeaApp',
  router,
  render: (h) => h(IdeaApp),
});
