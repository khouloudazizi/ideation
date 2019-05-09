<template>
<v-layout class="bt">
    <v-dialog v-model="dialog" persistent max-width="500px">
      <v-btn  slot="activator"  color="#0000FF" dark><i class="fas fa-plus-circle"></i> créer une idée </v-btn>
      <v-card>
          <v-container class="backgroundTop" >
        <v-card-title>
          <span class="headline">Créer une Idée</span>
        </v-card-title>
        <v-card-text >
          <v-form
    ref="form"
    v-model="valid"
    lazy-validation
    class="textet"
  >
  <v-text-field
      v-model="title"
      :counter="10"
      :rules="nameRules"
      placeholder="Titre" 
      required
      prepend-icon="edit"
    ></v-text-field>
   
      <v-textarea   prepend-icon="edit" v-model="description" placeholder="Description ..."  /> 
  
              
          </v-form>
        
        </v-card-text>
        </v-container>
        
        <v-card-actions >
          <v-spacer></v-spacer>
           <v-btn color="red" flat @click="reset">reset</v-btn>

          <v-btn color="blue darken-1" flat @click="annuler">Close</v-btn>
          <v-btn color="blue darken-1" flat @click="addIdea">Save</v-btn>
        </v-card-actions>
       
      </v-card>
    </v-dialog>
</v-layout>
 
</template>
<script>
import axios from 'axios';
 export default {
  data() {
    return { 
            dialog: false,
title:'',
description:'',
     
 datajson:{
             createdTime:'' ,
             title:'',
             description:'',
             user:'root',
             status:"DRAFET"
          },


           
    }
  },
   methods: {

       addIdea(){
    this.datajson.title=this.title;
    this.datajson.description=this.description;
    this.datajson.createdTime=new Date();
    console.log(this.datajson);
       axios.post('http://127.0.0.1:8080/portal/rest/idea/addIdea', this.datajson, {
    headers: {
      'Content-type': 'application/json',
    }
   }) 
   
   this.title='';
   this.description='';
 
       
    },
    reset() {
       this.title= null;
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