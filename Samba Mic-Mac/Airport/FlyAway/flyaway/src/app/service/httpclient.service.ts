import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pilote } from '../pilote';
import { CATCH_ERROR_VAR } from '@angular/compiler/src/output/output_ast';


/* export class Employee{
  constructor(
    public empId:string,
    public name:string,
    public designation:string,
    public salary:string,
  ) {}
} */

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor( private http :HttpClient) { }

    private baseUrl =  "http://localhost:8090/api/pilote";

 
    // Header set Access-Control-Allow-Origin "*";
     

  getPilote() {
    let token = localStorage.getItem('access_token');
    return this.http.get<Pilote[]>(this.baseUrl);
  }

  getPiloteById(id: number) {
    let token = localStorage.getItem('access_token');
    return this.http.get<Pilote>(this.baseUrl + '/' + id);
  }

  createPilote(pilote: Pilote) {
    return this.http.post(this.baseUrl, pilote);
  }

  updatePilote(pilote: Pilote) {
    return this.http.post(this.baseUrl, pilote);
  }

  deletePilote(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }


getHeaders(){
  let username='admin'
  let password='password'

  let  basicString='Basic '+window.btoa(username + ':' + password)
  return basicString;
 }

}

/* 
     getEmployees()
  {
    let basicString=this.getHeaders();

    let headers=new HttpHeaders(
      {Authorization:basicString}
    );
    console.log("test call");
    return this.httpClient.get<Employee[]>('http://localhost:8080/employees',{headers});
  }

  public deleteEmployee(employee) {
    return this.httpClient.delete<Employee>("http://localhost:8080/employees" + "/"+ employee.empId);
  }

  public createEmployee(employee) {
    return this.httpClient.post<Employee>("http://localhost:8080/employees", employee);
  } */
