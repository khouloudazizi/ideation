<template>
  <v-container class="my-5 backgroundTop" elevation-20>
    <v-stepper
      v-model="e1"
      flat
      class="text-xs-center ma-3 elevation-20"
     >
      <v-stepper-header>
        <v-stepper-step  step="1">
     
          <h4 class="blue--text .headline">Create Idea</h4>
        </v-stepper-step>
      </v-stepper-header>

      <v-stepper-items>
           <v-stepper-content step="1">
              <v-card 
        
            class="mx-5"
            height="350px">
            <v-card-text>
            
              <v-form ref="form" class="mx-5 px-3" >
                <v-container>
                  <v-flex md12 lg12>
                 
                    <v-text-field 
                     v-model="Title"
                     label="Title"
                     
                      />
                  </v-flex>
                 
                  <v-flex >
                  
                    <v-textarea
                      v-model="Description"
                      label="Description"
                     
                      />
                  </v-flex>

      
                  <!--  @click="submit"  -->
                </v-container>

              </v-form>
            </v-card-text>
          </v-card>
    
       
       </v-stepper-content>
     
          <v-btn
            depressed
            large
            color="#1867c0"
            class="white--text"
         >
            Continue
          </v-btn>

          <v-btn
            v-btn
            outline
            large
            color="blue darken-3"
            class="indigo--text">
            Cancel
          </v-btn>
      
      
      </v-stepper-items>
    </v-stepper>
      
    

         
       
  
  </v-container>
</template>


<script>
 
  
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