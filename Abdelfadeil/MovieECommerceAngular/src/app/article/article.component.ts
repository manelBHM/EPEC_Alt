import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, NavigationEnd } from '@angular/router';
import { ArticleServiceService } from '../service/article-service.service';
import { ArticleModule } from './article.module';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
id;
  url: string;
  article: ArticleModule;
  constructor(private router:Router, private articleService: ArticleServiceService, private acitvatedRoute: ActivatedRoute) {

    this.router.events.subscribe( val => {
      if(val instanceof NavigationEnd) {
        this.url = val.url;
        console.log(this.url);
        this.id= this.acitvatedRoute.snapshot.params.id;
      }
    })
   }

  ngOnInit() {
      this.articleService.getArticle(this.id).subscribe(data=> {
        this.article=data;
        console.log(this.article);
      }, error=> {
        console.log(error);
      })
  

}

}
