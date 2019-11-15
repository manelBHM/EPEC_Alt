import { Component, OnInit } from '@angular/core';
import { ArticleServiceService } from '../service/article-service.service';
import { Router } from '@angular/router';
import {NgForm} from '@angular/forms';
import { ArticleModule } from '../article/article.module';
import {HttpEventType, HttpResponse} from "@angular/common/http";


@Component({
  selector: 'app-ajouter-article',
  templateUrl: './ajouter-article.component.html',
  styleUrls: ['./ajouter-article.component.css']
})
export class AjouterArticleComponent implements OnInit {
  article: ArticleModule;
  fileToUpload: File = null;
  save:number=1;
  private currentArticle:ArticleModule;
  private progress: number;


  constructor(private articleService:ArticleServiceService, private router: Router) { }

  ngOnInit() {
  }


  onSubmit(f: NgForm){
    this.article = f.value;

    this.articleService.ajouterArticle(this.article).subscribe(data => {
    console.log(data);
    this.currentArticle=data;
    this.save=2;
   // this.router.navigateByUrl('/admin-console');
    }, err => {
      console.log(err);

    })

  }

  fileUpload(event) {
    this.fileToUpload = <File>event.target.files.item(0);
    console.log(this.fileToUpload);

  }

  savPhoto(id) {
    this.progress=0;
   const formdata = new FormData();

    formdata.append('file', this.fileToUpload, this.fileToUpload.name);
    this.articleService.uploadPhoto(formdata, id).subscribe(event=> {
      if(event.type === HttpEventType.UploadProgress){
        this.progress= Math.round(100* event.loaded / event.total)
      } else if ( event instanceof HttpResponse){
        alert('Chargement succèss ...');
       // this.router.navigateByUrl('/admin-console');
      }
    }, error => {
      alert('Erreur de chargement ... '+error);
    })
  }
}
