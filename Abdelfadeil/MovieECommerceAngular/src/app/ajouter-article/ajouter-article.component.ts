import { Component, OnInit } from '@angular/core';
import { ArticleServiceService } from '../service/article-service.service';
import { Router } from '@angular/router';
import {NgForm} from '@angular/forms';
import { ArticleModule } from '../article/article.module';
import {HttpEventType, HttpResponse} from "@angular/common/http";
import {CategoryModule} from "../category/category.module";
import {CategoryService} from "../service/category.service";


@Component({
  selector: 'app-ajouter-article',
  templateUrl: './ajouter-article.component.html',
  styleUrls: ['./ajouter-article.component.css']
})
export class AjouterArticleComponent implements OnInit {
  article: ArticleModule;
  fileToUpload: File = null;
  save:number=1;
  private progress: number;
  private idCategory: number;
  categories:CategoryModule [];
  private category: CategoryModule = new CategoryModule(this.idCategory, '', '');



  constructor(private articleService:ArticleServiceService, private router: Router, private catService:CategoryService) { }

  ngOnInit() {
    this.chargerCategories();
  }


  chargerCategories(){
    this.catService.getCategories(0, 100).subscribe( data => {
       this.categories= data;
    }, err => {
      console.log(err);
    })
  }

  onSubmit(f: NgForm){
    this.article=f.value;
    console.log(f.value);
    let id =f.value.idCategory;
    this.catService.getCategorie(id).subscribe( data => {
      this.category= data;
    })

    console.log("my cat  "+  this.category);
    console.log("id cat  "+ this.category.id);
    this.article.category= this.category;
    console.log(" encore  cat " +this.article.category);

    this.articleService.editerArticle(this.article).subscribe(data => {
      this.article=data;
      this.save=2;
      // this.router.navigateByUrl('/admin-console');
    }, error => {
      console.log(error)
    })

  }

  fileUpload(event) {
    this.fileToUpload = <File>event.target.files.item(0);
    console.log(this.fileToUpload);

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
}
