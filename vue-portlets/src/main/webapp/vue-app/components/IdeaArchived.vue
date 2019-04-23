<template>
  <div class="team">
    

    <v-container class="my-5">

      <v-layout row wrap>
        <v-flex xs12 sm6 md4 lg3 v-for="idea in ideas" :key="idea.titre">
          <v-card flat  class="text-xs-left ma-4"
    color=""
    dark
    >
           
            <v-card-text>
              
              <div class="subheading" >
            

             <i class="far fa-address-card" color="blue"></i>
            Titre :{{ idea.titre }}</div>


              <div class="grey--text">
                <i class="fas fa-user-graduate"></i>
                Crée par :{{ idea.user }}</div>

              <div class="grey--text">
                <i class="fas fa-calendar"></i>
                le :{{ idea.date}}</div>

            </v-card-text>
            <v-card-actions>
              <router-link to="/ideainfo">
           <v-spacer></v-spacer>
      <v-icon
        large
       mdi-chevron-right>
      </v-icon>
              </router-link>
            </v-card-actions>
          </v-card>
        </v-flex>
      </v-layout>

    </v-container>
    
  </div>
</template>

<script>
export default {
  data() {
    return {
      ideas: [
        { titre: 'The Net Ninja', user: 'Web developer',date :"01-03-2019" },
        { titre: 'Ryu', user: 'Graphic designer' ,date :"01-03-2019"},
        { titre: 'Chun Li', user: 'Web developer' ,date :"01-03-2019" },
        { titre: 'Gouken', user: 'Social media maverick' ,date :"01-03-2019"  },
        { titre: 'Yoshi', user: 'Sales guru' ,date :"01-03-2019"}
      ]
    }
  }
}
</script>

<style>

</style>
