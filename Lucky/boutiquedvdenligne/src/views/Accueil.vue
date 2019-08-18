<template>

  <div id="content">
<div id="flou"></div>
    <carrousel/>
  
   <allcatalogue/>

  </div>
</template>


<style>
body{
   background: rgb(33, 37, 41);
  z-index: -1;
}

#content{
    height: auto;
    z-index: 1;
}

</style>



<script>
import allcatalogue from '@/components/Home.vue'
import carrousel from '@/components/CarrouselAccueil.vue'

export default {
  name: 'accueil',
  components: {
    allcatalogue,
    carrousel
  }
}
</script>