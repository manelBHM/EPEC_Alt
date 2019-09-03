import { Component, OnInit } from '@angular/core';
import { ArticleServiceService } from '../service/article-service.service';
import { ArticleModule } from '../article/article.module';
import { Router } from '@angular/router';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {
  currentMotCle: String="";
  currentPage: number=0;
  size: number=15;
  totalPages: number;
  pages: number[];
  articles;

  constructor(private articleService:ArticleServiceService, private router:Router) { }

  ngOnInit() {
   this.chercherArticles();

  }

  chercherArticles() {
    this.articleService.getArticles(this.currentMotCle, this.currentPage, this.size).subscribe(data => {
       console.log(data);
       this.totalPages=data["pageable"].totalPages;
       this.pages= new Array<number>(this.totalPages);
       this.articles=data;
    }, error => {
      console.log(error);
      this.router.navigateByUrl('/login')
    }
    )
  }


}
