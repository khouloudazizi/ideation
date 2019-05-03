<template> 
<v-container >
<div class="ideas"> 



  <v-expansion-panel>
  <v-expansion-panel-content v-for="d in donnes" :key="d.id">
  <div slot="header" class="py-1">{{ d.title }}</div>
  <v-card>
  <v-card-text class="px-4 grey--text">
  <div>{{ d.description }}  </div>

<div class="font-weight-bold">créer par {{d.user}} le {{ d.createdTime }}</div>
    <v-dialog v-model="dialog" persistent max-width="500px">
      <button slot="activator" class="btn" @click="update">Modifier </button>
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
      v-model="d.title"
      :counter="10"
      :rules="nameRules"
     prepend-icon="edit"
    
    ></v-text-field>
   
      <v-textarea   prepend-icon="edit" v-model="d.description" placeholder="Description ..."  /> 
  
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
      <button slot="activator" class="btn" >Supprimer </button>
      <button slot="activator" class="btn-primary">publier</button>







</v-card-text> 
</v-card> 
</v-expansion-panel-content> 
</v-expansion-panel> 


</div> 
</v-container>
</template> 

<script> 
import axios from 'axios';
export default { 
data() { 
return {
 donnes:[],
 dialog: false,
 title:'',
description:'',
     
 datajson:{
             createdTime:'' ,
             title:'',
             description:'',
             user:'exoPlatform26',
             status:""
          },

    
  }},
 mounted () { 
    
    axios
      .get('http://127.0.0.1:8080/portal/rest/idea/all/DRAFET')
      .then(response => { this.donnes=response.data;
        
      })
      .catch(error => {
        console.log(error)
        this.errored = true
      })
      
  },

   methods: {

     update(){
         this.datajson.title=this.title;
         this.datajson.description=this.description;
         this.datajson.createdTime=new Date();
         this.datajson.status="DRAFET"
         console.log(this.datajson);
        axios.put('http://127.0.0.1:8080/portal/rest/idea/update', this.datajson, {
    headers: {
      'Content-type': 'application/json',
    }
   }) 
      this.title='';
      this.description='';


     },

  
     

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








