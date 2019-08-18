<template>
    <div>
 
<div class="container">
  <h1>CATALOGUE</h1>
  <div class="row">

  <div class="col-sm" v-for="(items, n) in table_film" :key="n">

     <div class="card" id="card_catalogue" style="width: 18rem;">


     <img :src="require('@/assets/image/'+items.image)" class="card-img-top" alt=""/>


  <div class="card-body" id="body_card">

    <h5 class="card-title"><span class="label">Titre:</span>  {{items.titre}} </h5>

<div v-for="myitem in table_catalogue">
              <h5 class="card-title" v-if="items.catalogue_film_id == myitem.id"><span class="label">Catégorie:</span>  {{myitem.genre}} </h5>
  </div>

<h5><span class="label">Description</span></h5>
<div id="desc">
  <p class="card-text">{{items.description_film}} </p>

</div>
 
  <div v-for="item in table_langue">
              <h5 class="card-title" v-if="items.langue_id == item.id"><span class="label">Langue:</span>  {{item.nom}} </h5>
  </div>

    <h5 class="card-title"><span class="label">Prix:</span> {{items.prix_film}}€ (euro) </h5>

    <h5 class="card-title" v-if="items.disponible == 'non'">Disponible:  <span class="dispo" style="background:red; padding:2px; color: white">{{items.disponible}}</span>  </h5>
     <h5 class="card-title" v-else-if="items.disponible == 'oui'">Disponibilité:  <span class="dispo" style="background:greenyellow; padding:2px">{{items.disponible}}</span>  </h5>
    <a href="#" class="btn btn-primary">Ajouter au panier</a>
  </div>
</div>

    </div>
  
</div>
</div>
    </div>
</template>



<script>

import axios from 'axios';

export default {
    data()
    {
        
        return {
           
            table_film : [],
            table_langue : [],
            table_catalogue : [],
        };
    },

    created() {
        const film = "http://localhost:3030/boutiquedvd/api/film";

        axios.get(film).then(response =>{
            
            this.table_film = response.data;
            console.log(this.table_film);
        }).catch(error => {
            console.error(" Can error occured == >" + " " + error);
        })



         const langue = "http://localhost:3030/boutiquedvd/api/langue";

        axios.get(langue).then(res =>{
            
            this.table_langue = res.data;
            console.log(this.table_langue);
        }).catch(e => {
            console.error(" Can error occured == >" + " " + e);
        })



          const categorie = "http://localhost:3030/boutiquedvd/api/catalogue";

        axios.get(categorie).then(r =>{
            
            this.table_catalogue = r.data;
            console.log(this.table_catalogue);
        }).catch(err => {
            console.error(" Can error occured == >" + " " + err);
        })
    }
}
</script>



<style scoped>
#card_catalogue{
   width: 15rem;
  margin-bottom: 50px
}



#card_catalogue img{
    max-height: 340px;
}


.card-body{
    height: auto;
background: grey
}

#desc{
    height: 50px;
    overflow: auto;
    margin-bottom: 5px
}


.label{
    font-weight: bold;
    color: rgb(28, 28, 90)
}


h1{
    margin: 100px 0 100px 0;
    text-align: center;
    color: white
}
</style>

