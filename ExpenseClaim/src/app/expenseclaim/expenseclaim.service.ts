import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ExpenseClaimModel } from '../Model/ExpenseClaim';
import { Employee } from '../Model/Employee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExpenseclaimService {

  constructor(public http:HttpClient) { }

  getEmployee(empId:String){
    return this.http.get<Employee>("http://localhost:9004/ems/employee/"+empId);
  }
  listExpenseClaims(claimId:number){
    return this.http.get<ExpenseClaimModel>("http://localhost:9004/ems/claim/"+claimId);
  }

  addExpenseClaim(claims:ExpenseClaimModel){
  return this.http.post<ExpenseClaimModel>("http://localhost:9004/ems/claim/addclaim",claims);
  }

  updateExpenseClaim(claims:ExpenseClaimModel){
    return this.http.put<ExpenseClaimModel>("http://localhost:9004/ems/claim/modifyclaim",claims);
    }

  getExpenseCode(){
    return this.http.get<number[]>("http://localhost:9004/ems/expense");
  }

  getFinanceCode(){
    return this.http.get<number[]>("http://localhost:9004/ems/finance");
  }

  getProjectCode(){
    return this.http.get<number[]>("http://localhost:9004/ems/project");
  }

  deleteExpenseClaim(id:number):Observable<boolean>{
    return this.http.delete<boolean>("http://localhost:9004/ems/claim/deleteclaim/"+id);
  }
}
