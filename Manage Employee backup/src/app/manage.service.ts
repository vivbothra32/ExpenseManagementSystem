import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Employee } from './model/employee';
import { Observable } from 'rxjs';
import { AdminClass } from './model/adminClass';
@Injectable({
  providedIn: 'root'
})
export class ManageService {
  admin : AdminClass;
  private baseUrl = 'http://localhost:8888/employee';
  constructor(private http: HttpClient) { }

  listEmployee() {
    return this.http.get<Employee[]>(this.baseUrl+"/");
  }
  saveAdmin(admin : AdminClass){
    console.log("saving employee");
    this.admin = admin;
    console.log(admin);
    console.log(sessionStorage);
    
  }
  updateEmployee(employee: Employee) {
    let form=new FormData();
        form.append("empId", sessionStorage.getItem('empId'));
        form.append("pan", String(employee.pan));
        form.append("designation", String(employee.designation));
        form.append("domain", String(employee.domain));
        form.append("salary", String(employee.salary))

    return this.http.put<Employee>(this.baseUrl+"/update", form);
  }
  searchId(empId : string):Observable<Employee>{
    return this.http.get<Employee>(this.baseUrl+"/empId?empId="+empId);
  }

  loginAdmin(adminId : string, password : string):Observable<any>{
    //let form = new FormData();
    //form.append("empId",empId);
    //form.append("password",password);
    console.log("in service angular");

    return this.http.get("http://localhost:8880/project/login?id="+adminId+"&password="+password);
  }
  deleteEmployee() {
    console.log("Logged out successfully!")
    this.admin = null;
    sessionStorage.clear();
    alert("Logged out!");
  }
  deleteId(empId: string) : Observable<string> {
    console.log(empId);
    let form=new FormData();
    form.append("empId", empId);
    console.log(form);
    return this.http.get<string>(this.baseUrl+"/delete?empId="+empId);
  }
}
