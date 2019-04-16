<template>
 
  <div id="IdeaApp">

     <Home></Home>
    
        <router-view />
    </div>
</template>


 <script>
import Home from './Home.vue'
export default {
       components:{Home},
  
 
  }
  </script>
  <style ></style>
   