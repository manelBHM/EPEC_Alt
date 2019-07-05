import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  getEmployees() {
    return this.http.get('http://localhost:8080/employee');
  }

  getEmployee(id: number) {
    return this.http.get('http://localhost:8080/employee/' + id);
  }

  createEmployeeRegistration(employee) {
    let body = JSON.stringify(employee);
    return this.http.post('http://localhost:8080/employee', body, httpOptions);
  }

  deleteEmployee(id: number) {
    return this.http.delete('http://localhost:8080/employee/' + id);
  }

  saveEmployee(employee) {
    let body =JSON.stringify(employee);
    return this.http.put('http://localhost:8080/employee/update', body, httpOptions);
  }
}
