import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Employee } from './model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
 
  flag : boolean = false;
  employee : Employee;
  private baseUrl = 'http://localhost:8888/employee';
  constructor(private http: HttpClient) {
   }
  saveEmployee(emp : Employee){
    console.log("saving employee");
    this.employee = emp;
    console.log(emp);
    console.log(sessionStorage);
    
  }
  
  createEmployee(employee: Employee): Observable<Employee> {
    let form=new FormData();
        form.append("empId", String(employee.empId));
        form.append("name",String(employee.name));
        form.append("pan", String(employee.pan));
        form.append("designation", String(employee.designation));
        form.append("domain", String(employee.domain));
        form.append("dateOfBirth", new Date(employee.dateOfBirth).toUTCString());
        form.append("email",String(employee.email));
        form.append("password", String(employee.password));
        form.append("salary", String(employee.salary));

    return this.http.post<Employee>(this.baseUrl+'/add', form);
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
  deleteId(empId: string) : Observable<string> {
    console.log(empId);
    let form=new FormData();
    form.append("empId", empId);
    console.log(form);
    return this.http.get<string>(this.baseUrl+"/delete?empId="+empId);
  }
  
  
  searchId(empId : string):Observable<Employee>{
    return this.http.get<Employee>(this.baseUrl+"/empId?empId="+empId);
  }
  searchDomain(domain : String):Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl+"/domain?domain="+domain);
  }
  searchDesignation(designation : String):Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl+"/designation?designation="+designation);
  }
  loginEmployee(empId : string, password : string):Observable<Employee>{
    //let form = new FormData();
    //form.append("empId",empId);
    //form.append("password",password);
    console.log("in service angular");

    return this.http.get<Employee>(this.baseUrl+"/login/?empId="+empId+"&password="+password);
  }
  listEmployee() {
    return this.http.get<Employee[]>(this.baseUrl+"/");
  }
  changePassword(empId: string, oldPassword: string, newPassword: string):Observable<Employee> {
    let form = new FormData();
    form.append("empId",empId);
    form.append("oldPassword",oldPassword);
    form.append("newPassword",newPassword);
    return this.http.get<Employee>(this.baseUrl+"/password/?empId="+sessionStorage.getItem('empId')+"&oldPassword="+oldPassword+"&newPassword="+newPassword);
  }
  addBank( bankName : string, accountNo : string, salary : string):Observable<any> {
    let form=new FormData();
        form.append("empId", String(this.employee.empId));
        form.append("bankName", String(bankName));
        form.append("accountNumber", String(accountNo));
    let params = new HttpParams().append('empId',this.employee.empId).append('bankName',bankName).append('accountNo',accountNo).append('salary', salary);
      return this.http.get(this.baseUrl+'/bank?empId='+sessionStorage.getItem('empId')+"&bankName="+bankName+"&accountNumber="+accountNo+"&salary="+salary);
    //return this.http.post(this.baseUrl+"/bank/"+this.employee.empId+"/"+bankName+"/"+accountNo);
  }

  deleteEmployee() {
    console.log("Logged out successfully!")
    this.employee = null;
    sessionStorage.clear();
    alert("Logged out!");
  }
  
}
