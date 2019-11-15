import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, NavigationEnd } from '@angular/router';
import { NgForm } from '@angular/forms';
import { ArticleServiceService } from '../service/article-service.service';
import { ArticleModule } from '../article/article.module';
import {HttpEventType, HttpResponse} from "@angular/common/http";

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
  editer: number=1;
    progress: number;
   fileToUpload: File = null;
  private currentArticle:ArticleModule;
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
     this.editer=2;
    // this.router.navigateByUrl('/admin-console');
  }, error => {
    console.log(error)
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
