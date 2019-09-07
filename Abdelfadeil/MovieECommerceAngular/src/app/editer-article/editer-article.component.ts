import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, NavigationEnd } from '@angular/router';
import { NgForm } from '@angular/forms';
import { ArticleServiceService } from '../service/article-service.service';
import { ArticleModule } from '../article/article.module';

@Component({
  selector: 'app-editer-article',
  templateUrl: './editer-article.component.html',
  styleUrls: ['./editer-article.component.css']
})
export class EditerArticleComponent implements OnInit {
  url;
  article:ArticleModule = new ArticleModule();
  // currentId: any;
  id: any;

  constructor(private router:Router, private activatedRoute:ActivatedRoute, private articleService:ArticleServiceService) { }

  ngOnInit() {
  
  this.id= this.activatedRoute.snapshot.params.id;
  console.log(this.id);
   let id = atob(this.id);
   console.log(id);
    this.articleService.getArticle(id).subscribe(data=> {
      this.article=data;
    }, error => {
      console.log(error);
    })
  }


  onSubmit(f:NgForm){
  this.articleService.editerArticle(f.value).subscribe(data => {
     this.article=data;
     this.router.navigateByUrl('/admin-console');
  }, error => {
    console.log(error)
  })
  }
}
