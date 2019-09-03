import { Component, OnInit, ViewChild, ElementRef  } from '@angular/core';
import { Router } from '@angular/router';
import { ArticleServiceService } from '../service/article-service.service';
import { AuthentificationService } from '../authentification.service';

declare var $;


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  @ViewChild('dataTable',  {static: false}) table: ElementRef;
  dataTable:any;

  boucles:number[]= [1,2,3,4,5,6,7,8,9,10,11,12, 13,14, 15, 16, 17, 18, 19, 20];
  currentPage:number=0;
  page:number=0;
  size:number=20;
  totalPages: number;
  pages: number[];
  currentMotCle: String="";
  articles:any;
public  slide: boolean= false;
  tour:number=4;


  constructor(private articleService:ArticleServiceService, private router:Router, private autService:AuthentificationService) { }


  ngOnInit() {
      this.chercherArticles();

  }

  slider(){

  }



  chercherArticles() {
    this.articleService.getArticles(this.currentMotCle, this.currentPage, this.size).subscribe(data=> {
      console.log(data);
      console.log(this.totalPages);
      this.totalPages=data["pageable"].tottotalPages;
      this.pages= new Array<number>(this.totalPages);
      this.articles=data;

    }, err=> {
      console.log(err);
      this.autService.logout();
      this.router.navigateByUrl('/login');
    })


}
}
