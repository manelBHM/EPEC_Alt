import { Component, OnDestroy, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ArticleServiceService } from '../service/article-service.service';
import { Router } from '@angular/router';
import * as jQuery from 'jquery';import { ArticleModule } from '../article/article.module';
 window['$'] = jQuery;

@Component({
  selector: 'app-admin-console',
  templateUrl: './admin-console.component.html',
  styleUrls: ['./admin-console.component.css']
})
export class AdminConsoleComponent implements OnInit {
  currentMotCle:String='';
  currentPage:number=0;
  page:number=0;
  size:number=1500;
  totalPages: number;
  pages: number[];
  articles: any;
  
  
  
  
  constructor(private http: HttpClient, private articleService:ArticleServiceService, private router:Router) { }
  
  ngOnInit() {
      this.chargerArtiles();  
      var $ = jQuery;   
      require( 'datatables.net-bs4' )();
      require( 'datatables.net-buttons-bs4' )();

      $(document).ready(function() {
        $(".datatable").DataTable();
    });
    
   
    }


    getArticles(){
      this.articleService.getArticlesList().subscribe(data=>{
        this.articles=data;
      }, err=>{
        console.log(err);
        this.router.navigateByUrl('/login');
      })
    }

    chargerArtiles(){
      this.articleService.getArticles(this.currentMotCle, this.currentPage, this.size).subscribe(data => {
        console.log(data);
        console.log('on onchercherArticles')
         this.totalPages=data["pageable"].totalPages;
         this.pages= new Array<number>(this.totalPages);
         this.articles=data;
        }, error => {
          console.log(error);
          this.router.navigateByUrl('/login')
        });
    }
 
    onDelete(id) {
      this.articleService.supprimer(id).subscribe(data=> {
        this.chargerArtiles();
       this.router.navigateByUrl('/admin-console');
        console.log(data);
      }, err=> {
        console.log(err);
      })

    }

    editer(a){
      let id = btoa(a);
     // console.log(url)
      this.router.navigateByUrl('/editer-article/'+id);


    }
  
}
