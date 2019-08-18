
   <template>

    <div>
      <header>
          
          <nav class="navbar fixed-top navbar-expand-lg">
            <a class="navbar-brand avatar" href="#" title="Acheter vos DVD en ligne" target="blank">DVD en ligne</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
              <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                  <a class="nav-link" href="http://localhost:8080/accueil">Acceuil<span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item">
                  <a class="nav-link" href="#competences">Connectez-vous</a>
                </li>

                <li class="nav-item">
                  <a class="nav-link" href="#experience_pro">Créer un compte</a>
                </li>
              </ul>
            </div>
          </nav>
        </header>
         
<router-view/>
    </div>
</template>
    
  


<style lang="css" scoped>
nav{
  background: black;
}

nav a{
  text-decoration: none;
  color: white!important;
}

nav a:hover{
  background: #2e558d;
}


nav>a{
  background: #2e558d;
  padding: 10px;
  font-weight: bold
}
</style>

 