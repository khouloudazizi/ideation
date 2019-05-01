<template>
  <v-layout row>
    <v-flex xs12 sm8 offset-sm1>
      <v-card>
       <v-list two-line>
          <template v-for="(idea, index) in ideas">
            <v-list-tile
              :key="idea.titre"
              avatar
              ripple
              @click="toggle(index)"
            >
              <v-list-tile-content>
                <v-list-tile-title>{{ idea.titre }}</v-list-tile-title>
                <v-list-tile-sub-title class="text--primary">{{ idea.user }}</v-list-tile-sub-title>
                <v-list-tile-sub-title>{{ idea.date }}</v-list-tile-sub-title>
              </v-list-tile-content>

           

                <v-icon
                
                  color="yellow darken-2"
                >
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
  export default {
    data () {
      return {
        selected: [2],
         ideas: [
        { titre: 'The Net Ninja', user: 'Web developer',date :"01-03-2019" },
        { titre: 'Ryu', user: 'Graphic designer' ,date :"01-03-2019"},
        { titre: 'Chun Li', user: 'Web developer' ,date :"01-03-2019" },
        { titre: 'Gouken', user: 'Social media maverick' ,date :"01-03-2019"  },
        { titre: 'Yoshi', user: 'Sales guru' ,date :"01-03-2019"}
      ]
        
      }
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



