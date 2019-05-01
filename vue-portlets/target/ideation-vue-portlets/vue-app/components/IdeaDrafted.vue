<template> 
<v-container >
<div class="ideas"> 


<v-expansion-panel> 
<v-expansion-panel-content v-for="idea in ideas" :key="idea.title"> 
<div slot="header" class="py-1">{{ idea.title }}</div> 
<v-card> 
<v-card-text class="px-4 grey--text"> 
<div class="font-weight-bold">Faite le {{ idea.date }}</div> 
<div>{{ idea.Description}}</div> 
    <v-dialog v-model="dialog" persistent max-width="500px">
      <v-btn slot="activator" color="blue">Modifier</v-btn>
    <v-card>
          <v-container class="backgroundTop" >
        <v-card-title>
          <span class="headline">Modifier une Idée</span>
        </v-card-title>
        <v-card-text >
          <v-form
    ref="form"
    v-model="valid"
    lazy-validation
    class="textet"
  >
  <v-text-field
      v-model="idea.title"
      :counter="10"
      :rules="nameRules"
     prepend-icon="edit"
    
    ></v-text-field>
   
      <v-textarea   prepend-icon="edit" v-model="idea.description" placeholder="Description ..."  /> 
  
                    <v-flex md10>
                      <select
                         class="select_style"
                        :options="option"
                        placeholder="Categories" >
                        <option v-for="option in options" :key="option.id">
                          {{ option.status }}
                        </option>
                      </select>
                  
                    </v-flex>
          </v-form>
        
        </v-card-text>
        </v-container>
        
        <v-card-actions >
          <v-spacer></v-spacer>
           <v-btn color="red" flat @click="reset">reset</v-btn>
           <v-btn color="blue darken-1" flat @click="annuler">Close</v-btn>
          <v-btn color="blue darken-1" flat @click="annuler">Save</v-btn>
        </v-card-actions>
       
      </v-card>
  </v-dialog>
      <v-btn slot="activator" color="#FF0000">Supprimer</v-btn>






</v-card-text> 
</v-card> 
</v-expansion-panel-content> 
</v-expansion-panel> 


</div> 
</v-container>
</template> 

<script> 
export default { 
data() { 
return {
   
ideas: [ 
{ title: 'Design a new website', date: '1st Jan 2019', description: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt consequuntur eos eligendi illum minima adipisci deleniti, dicta mollitia enim explicabo fugiat quidem ducimus praesentium voluptates porro molestias non sequi animi!', option: 'drafted'}, 
{ title: 'Code up the homepage', date: '10th Jan 2019', description: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt consequuntur eos eligendi illum minima adipisci deleniti, dicta mollitia enim explicabo fugiat quidem ducimus praesentium voluptates porro molestias non sequi animi!', option: 'drafted'}, 
{ title: 'Design video thumbnails', date: '20th Dec 2018', description: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt consequuntur eos eligendi illum minima adipisci deleniti, dicta mollitia enim explicabo fugiat quidem ducimus praesentium voluptates porro molestias non sequi animi!', option: 'drafted'}, 
{ title: 'Create a community forum', date: '20th Oct 2018', description: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt consequuntur eos eligendi illum minima adipisci deleniti, dicta mollitia enim explicabo fugiat quidem ducimus praesentium voluptates porro molestias non sequi animi!', option: 'drafted'}, 
] ,

       
dialog: false,
 options: [
            {status:"publiée",id:"1"},
            {status:"drafted",id:"3"}
            ]
    
  }},
   methods: {
    reset() {
       this.titre= null;
       this.description=null;
       console.log("ok");
       
    },
    annuler(){
      this.dialog=false;
     
      console.log(this.dialog);
    }
   }
}



 


</script>
<style>
.textet{
  width: 72%;
 
}
.bt{
justify-content: flex-end;
width: 95%;
}
 .backgroundTop{
        background:linear-gradient(to bottom, #1867c0, #5CBBF6);
      font-family: 'Avenir', Helvetica, Arial, sans-serif;
      -webkit-font-smoothing: antialiased;
      -moz-osx-font-smoothing: grayscale;
      text-align: center;
      color: #2c3e50;
    }
    .select_style{
      margin-left: 12%;
      width: 108%;
    }
</style>








