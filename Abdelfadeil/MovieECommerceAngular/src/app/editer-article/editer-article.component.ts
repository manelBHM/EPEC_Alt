import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, NavigationEnd } from '@angular/router';
import { NgForm } from '@angular/forms';
import { ArticleServiceService } from '../service/article-service.service';
import { ArticleModule } from '../article/article.module';
import {HttpEventType, HttpResponse} from "@angular/common/http";
import {CategoryService} from "../service/category.service";
import {CategoryModule} from "../category/category.module";

@Component({
  selector: 'app-editer-article',
  templateUrl: './editer-article.component.html',
  styleUrls: ['./editer-article.component.css']
})
export class EditerArticleComponent implements OnInit {
  url;
  article:ArticleModule;
  // currentId: any;
  idCategory;
  id: any;
  editer: number=1;
    progress: number;
   fileToUpload: File = null;
  private currentArticle:ArticleModule;
  private categories: CategoryModule [];
  private category: CategoryModule = new CategoryModule(this.idCategory, '', '');
   constructor(private router:Router, private activatedRoute:ActivatedRoute, private articleService:ArticleServiceService, private catService:CategoryService) { }

  ngOnInit() {

  this.id= this.activatedRoute.snapshot.params.id;
  console.log(this.id);
   let id = atob(this.id);
   console.log(id);
    this.articleService.getArticle(id).subscribe(data=> {
      this.article=data;
      console.log("id cat ... "+ this.article.category);
    }, error => {
      console.log(error);
    })
    this.chargerCategories();

  }


  onSubmit(f:NgForm){
    this.article=f.value;
    console.log(f.value);
    let id =f.value.idCategory;
    this.catService.getCategorie(id).subscribe( data => {
      this.category= data;
    }, err => {
      console.log(err);
    })

    console.log("my cat  "+  this.category);
     console.log("id cat  "+ this.category.id);
    this.article.category= this.category;
    console.log(" encore  cat " +this.article.category);

     this.articleService.editerArticle(this.article).subscribe(data => {
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

  selectCat(event) {
   // this.category= event.target.value;
  //  console.log(this.category);
    console.log(event.target);


  }

  savePhoto(id) {
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

  chargerCategories(){
    this.catService.getCategories(0, 100).subscribe( data => {
      this.categories= data;
    }, err => {
      console.log(err);
    })
  }

}
export class Test {
  id:number;
  name:String;
  description:String;
}
