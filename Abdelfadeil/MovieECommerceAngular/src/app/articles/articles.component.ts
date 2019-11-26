import { Component, OnInit } from '@angular/core';
import { ArticleServiceService } from '../service/article-service.service';
import { ArticleModule } from '../article/article.module';
import { Router, ActivatedRoute, NavigationEnd } from '@angular/router';
import { CategoryService } from '../service/category.service';
import { CategoryModule } from '../category/category.module';
import { LigneCommandeModule } from '../ligne-commande/ligne-commande.module';
import { AuthentificationService } from '../service/authentification.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {
  currentMotCle: String='';
  //mc:String='';
  currentPage: number=0;
  catPage:number=0;
  currentCatPage=0;
  size: number=30;
  catSize: number=15;
  totalPages: number;
  catTotalPages: number;
  pages: number[];
  catPages: number[];
  public articles:any;
  public ligneCommandes : Array<LigneCommandeModule> = new Array<LigneCommandeModule>();

  article :ArticleModule = new ArticleModule();
  id:any;
  currentId;
  catCurrentId;
  url;
  mode: number;
 formSearch: boolean= true;
  show: boolean =false;
  categories;
  ligneCommande: LigneCommandeModule;

  constructor(
    private articleService:ArticleServiceService,
    private router:Router, private route: ActivatedRoute,
    private categoryService:CategoryService,
    private autService:AuthentificationService
    )
   {
    this.router.events.subscribe( val => {
      if(val instanceof NavigationEnd) {
        this.url = val.url;
        //console.log(this.url);
        this.currentId= this.route.snapshot.params.id;
        this.chercherArticlesCategory();
      }
    })

   }

  ngOnInit() {
    this. getAllCategories();
    console.log(this.autService.user);
  }



  onchercherArticles() {
    this.articleService.getArticles(this.currentMotCle, this.currentPage, this.size).subscribe(data => {
       console.log(data);
       console.log('on onchercherArticles')
       this.totalPages=data["pageable"].totalPages;
       this.pages= new Array<number>(this.totalPages);
       this.articles=data;
    }, error => {
      console.log(error);
      // this.router.navigate(['/login']);
    }
    )
  }


   onchercherArticlesCategoryForm(form:any) {
    this.currentMotCle=form.mc;
    console.log('event value  '+this.currentMotCle);
    if(this.currentId=='all')
    {
      this.articleService.getArticles(this.currentMotCle, this.currentPage, this.size).subscribe(data => {
        console.log(data);
        this.totalPages=data["pageable"].totalPages;
        this.pages= new Array<number>(this.totalPages);
        this.articles=data;
     }, error => {
       console.log(error);
      // this.router.navigateByUrl('/login')
     }
     )
    } else {
      //this.catCurrentId=
      this.articleService.getArticlesCategory(this.currentId, this.currentMotCle, this.currentPage, this.size).subscribe(data => {
        console.log(data);
        this.totalPages=data["pageable"].totalPages;
        this.pages= new Array<number>(this.totalPages);
        this.articles=data;
      }, error => {
        console.log(error);
        // this.router.navigateByUrl('/login')
      }
      )
    }
  }
  onchercherArticlesCategory(id) {
    this.currentId= id;
    if(this.currentId =='all'){
      this.router.navigateByUrl('/articles/'+ this.currentId);

    }else {
      this.router.navigateByUrl('/articles/'+ this.currentId);
    }

  }

  chercherArticlesCategory() {
    this.currentId= this.route.snapshot.params.id;
    if(this.currentId == 'all'){
      this.onchercherArticles();
    }else {

      console.log('on chercher by id méthode this.currentId= '+this.currentId);
      this.articleService.getArticlesCategory(this.currentId, this.currentMotCle, this.currentPage, this.size).subscribe(data => {
        console.log(data);
        this.totalPages=data["pageable"].totalPages;
        this.pages= new Array<number>(this.totalPages);
        this.articles=data;
     }, error => {
       console.log(error);
      // this.router.navigateByUrl('/login');
     }
     )
    }

  }

  onNavigateCagegory(id){
    //this.currentId= id;
    this.router.navigateByUrl('articles/'+id);
  }


  getAllCategories(){
    this.categoryService.getCategories(this.currentCatPage, this.catSize).subscribe(data=> {
      this.catTotalPages=data["pageable"].totalPages;
      this.catPages= new Array<number>(this.totalPages);
    this.categories= data;
    console.log('toutes les categories '+this.categories);
    }, error=> {
    //  console.log(error);
    })
  }

  ajouterArticlePanier(article:ArticleModule){
    this.articleService.addToCart(article).subscribe(data=> {
      this.ligneCommande=data;
    }, error=> {
      console.log(error);
       this.router.navigateByUrl('/login');
    })
  }

  getArticle(id){
    this.articleService.getArticle(id).subscribe(data=> {
      this.article=data;
    }, error=> {
      console.log(error);
    })
  }
  afficherArticle(id){

      this.router.navigateByUrl('/article/'+id)

  }






}
