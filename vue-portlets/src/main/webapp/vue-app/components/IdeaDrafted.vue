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
      <button slot="activator" class="btn">Modifier </button>
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
    
      :rules="nameRules"
     prepend-icon="edit"
    
    ></v-text-field>
   
      <v-textarea   prepend-icon="edit" v-model="d.description" placeholder="Description ..."  /> 
  
          </v-form>
        
        </v-card-text>
        </v-container>
        
        <v-card-actions >
          <v-spacer></v-spacer>
           <v-btn color="red"  @click="reset">reset</v-btn>
           <v-btn color="blue darken-1"  @click="annuler">Close</v-btn>
          <v-btn color="blue darken-1"  @click.prevent="UpdateIdea(d.id,d.title,d.description)">Save</v-btn>

        </v-card-actions>
       
      </v-card>
  </v-dialog>
      <button  class="btn" @click.prevent="DeleteIdea(d.id,index)">Supprimer </button>
      <button  class="btn-primary" @click.prevent="AddToPublished(d.id,d.title,d.description,index)">Publier</button>







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
datajson:{
        id:null,
        createdTime:null,
        title:'',
        description:'',
        status:'',
        user:'root'
    },

}},
    



 mounted () { 
    
    axios
      .get('http://127.0.0.1:8080/portal/rest/idea/allpublishedbyuser/DRAFET')
      .then(response => { this.donnes=response.data;
        
      })
      .catch(error => {
        console.log(error)
        this.errored = true
      })
  },

   methods: {
     DeleteIdea: function(event){
          const idx = this.donnes.indexOf(event);
             axios.delete('http://127.0.0.1:8080/portal/rest/idea/delete/'+event, {
              headers : {
                  'Content-Type' : 'application/json'
              }
          }).then( axios
      .get('http://127.0.0.1:8080/portal/rest/idea/allpublishedbyuser/DRAFET')
      .then(response => { this.donnes=response.data;
        
      })
      .catch(error => {
        console.log(error)
        this.errored = true
      }))

     },
     AddToPublished:function(id,title,description){
                const idx = this.donnes.indexOf();
                 
       this.datajson.status="PUBLISHED";
       this.datajson.createdTime=new Date();
     this.datajson.description=description;
     this.datajson.title=title;
     this.datajson.id=id;
  axios.put('http://127.0.0.1:8080/portal/rest/idea/update', this.datajson, {
    headers: {
      'Content-type': 'application/json',
    }
   }).then( axios
      .get('http://127.0.0.1:8080/portal/rest/idea/allpublishedbyuser/DRAFET')
      .then(response => { this.donnes=response.data;
        
      })
      .catch(error => {
        console.log(error)
        this.errored = true
      }))

     },
        UpdateIdea:function(id,title,description){

           this.datajson.status="DRAFET";
       this.datajson.createdTime=new Date();
     this.datajson.description=description;
     this.datajson.title=title;
     this.datajson.id=id;
     console.log(this.datajson);
 axios.put('http://127.0.0.1:8080/portal/rest/idea/update', this.datajson, {
    headers: {
      'Content-type': 'application/json',
    }
   }).then( axios
      .get('http://127.0.0.1:8080/portal/rest/idea/allpublishedbyuser/DRAFET')
      .then(response => { this.donnes=response.data;
        
      })
      .catch(error => {
        console.log(error)
        this.errored = true
      }))
        }
,

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








