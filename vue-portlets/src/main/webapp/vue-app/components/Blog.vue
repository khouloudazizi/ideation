<template>
  <v-container class="my-5 backgroundTop" elevation-20>

     
          <h2 style="color:white"> Create Idea </h2>
    


 
          <v-card
            class="mb-5"
            height="350px">
            <v-card-text>
              <v-form ref="form" class="px-3" >
                <v-container>
                  <v-flex md12 lg12>
                    <i class="fas fa-edit"></i>
                    <v-text-field v-model="Title"
                      label="Title"
                     
                      ma-5
                      pa-5 />
                  </v-flex>
                  <v-flex md12 lg12>
                  
                  </v-flex>
                  <v-flex md12 lg12>
                    <v-textarea
                      v-model="Description"
                      label="Description"
                     
                      ma-5
                      pa-5 />
                  </v-flex>

                 <div elevation-20>

                         <md-chips v-model="coworkers" md-placeholder="Add coworkers..."></md-chips>

                  </div>
      
                  <!--  @click="submit"  -->
                </v-container>

              </v-form>
            </v-card-text>
          </v-card>
       

          <v-btn
            depressed
            large
            color="#1867c0"
            class="white--text"
            @click="e1 = 2">
            Valider
          </v-btn>

          <v-btn
            v-btn
            outline
            large
            color="blue darken-3"
            class="indigo--text">
            Cancel
          </v-btn>
      
    

         
       
  
  </v-container>
</template>


<script>
 
    import 'vue-material/dist/vue-material.min.css'
    import 'vue-material/dist/theme/default.css'
    import vSelect from 'vue-select'
    import UploadButton from 'vuetify-upload-button';
    import TuiEditor from 'vue-tui-editor';
    Vue.use(TuiEditor)
    Vue.component('v-select', vSelect)
    Vue.component('upload-btn',UploadButton)
    export default {
       data: () => ({
    coworkers: [
  
    ]
  })
                 
              
    }
</script>
<style>
    .para_border{
        border: 4px dotted lightslategrey;
    }
      .backgroundTop{
        background:linear-gradient(to bottom, #1867c0, #5CBBF6);
    }
</style>