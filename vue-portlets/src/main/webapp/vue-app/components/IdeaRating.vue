<template>
<v-layout row class="styletocard">
<v-flex xs12 sm8 offset-sm1>
<v-card>
<v-list two-line>
<template v-for="(idea, index) in ideas">
 <v-list-tile
 :key="idea.title"
  avatar
   ripple
    @click="toggle(index)"
            >
  <v-list-tile-content>
  <v-list-tile-title>{{ idea.title }}</v-list-tile-title>
  <v-list-tile-sub-title class="text--primary"> Crée par : {{ idea.user }}</v-list-tile-sub-title>
  </v-list-tile-content>

           

<v-icon color="yellow darken-2">
   star
 </v-icon>

</v-list-tile>
 <v-divider
  v-if="index + 1 < ideas.length"
 :key="index"
 ></v-divider>
  </template>
  </v-list>
  </v-card>
  </v-flex>
  </v-layout>
</template>
<script>
import axios from 'axios';
  export default {
    data () {
      return {
      ideas:[],
        
      }
    },
    
 mounted () { 
    
    axios
      .get('http://127.0.0.1:8080/portal/rest/fav/getallordered')
      .then(response => { this.ideas=response.data;
        
      })
      .catch(error => {
        console.log(error)
        this.errored = true
      })
  },

    methods: {
      toggle (index) {
        const i = this.selected.indexOf(index)

        if (i > -1) {
          this.selected.splice(i, 1)
        } else {
          this.selected.push(index)
        }
      }
    }
  }
</script>
<style>
.styletocard{
  width: 146%;
  margin-left: -10%;
}
</style>




