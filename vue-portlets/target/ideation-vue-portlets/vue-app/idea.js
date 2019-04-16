import 'vuetify/dist/vuetify.min.css' // Ensure you are using css-loader
import Vuetify from 'vuetify';
import IdeaApp from './components/IdeaApp.vue';
import router from './router/index';
import VueMaterial from 'vue-material'
import 'vue-material/dist/vue-material.min.css'
import 'vue-material/dist/theme/default.css'
Vue.use(Vuetify);
Vue.use(VueMaterial);

const vueInstance = new Vue({
  el: '#IdeaApp',
  router,
  render: (h) => h(IdeaApp),
});
