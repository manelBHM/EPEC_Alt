import { Component, OnInit } from '@angular/core';
import { ArticleServiceService } from '../service/article-service.service';
import { Router } from '@angular/router';
import {NgForm} from '@angular/forms';
import { ArticleModule } from '../article/article.module';


@Component({
  selector: 'app-ajouter-article',
  templateUrl: './ajouter-article.component.html',
  styleUrls: ['./ajouter-article.component.css']
})
export class AjouterArticleComponent implements OnInit {
  article: ArticleModule;

  constructor(private articleService:ArticleServiceService, private router: Router) { }

  ngOnInit() {
  }


  onSubmit(f: NgForm){
    this.article = f.value;
    this.articleService.ajouterArticle(this.article).subscribe(data => {
    console.log(data)
    this.router.navigateByUrl('/admin-console');
    }, err => {
      console.log(err);

    })
   
  }
}
