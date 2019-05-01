<template>
  <div class="team">
    

      <v-card >
        <v-container class="my-5 backgroundTop" elevation-20>

      <v-layout row wrap>
        <v-flex xs12 sm6 md4 lg3 v-for="idea in ideas" :key="idea.titre">
          <v-card flat class="text-xs-left ma-3">
           
            <v-card-text>
              
              <div class="subheading" >
               
           
<spacer></spacer>
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
               <v-btn flat color="blue" right="true">
            <i class="fas fa-angle-double-right"></i>        
              </v-btn>
              </router-link>
               </v-card-actions>
          </v-card>
        </v-flex>
      </v-layout>
      </v-container>
      </v-card>


    
  </div>
</template>

<script>
export default {
  data() {
    return {
      ideas: [
        { titre: 'The Net Ninja', user: 'Web developer',date :"01-03-2019",description:""},
        { titre: 'Ryu', user: 'Graphic designer' ,date :"01-03-2019",description:""},
        { titre: 'Chun Li', user: 'Web developer' ,date :"01-03-2019",description:"" },
        { titre: 'Gouken', user: 'Social media maverick' ,date :"01-03-2019",description:"" },
        { titre: 'Yoshi', user: 'Sales guru' ,date :"01-03-2019",description:""}
      ]
    }
  }
}
</script>
 .backgroundTop{
        background:linear-gradient(to bottom, #CFD8DC, #5CBBF6);
      font-family: 'Avenir', Helvetica, Arial, sans-serif;
      -webkit-font-smoothing: antialiased;
      -moz-osx-font-smoothing: grayscale;
      text-align: center;
      color: #2c3e50;
    }