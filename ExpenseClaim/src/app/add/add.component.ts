import { Component, OnInit } from '@angular/core';
import { ExpenseClaimModel } from '../Model/ExpenseClaim';
import { ExpenseclaimService } from '../expenseclaim/expenseclaim.service';
import { Router } from '@angular/router';
import { Employee } from '../Model/Employee';
import { MergeMapSubscriber } from 'rxjs/internal/operators/mergeMap';
import { Alert } from 'selenium-webdriver';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  claim:ExpenseClaimModel;
  result:ExpenseClaimModel;
  employeeDetails:Employee;
  empExist:boolean = false;
  employeeId:String;
  projectIds:number[];
  expenseIds:number[];
  clientIds:number[] = [301,302,303];
  financeUserIds:number[];
  check:String=null;
  startDate:Date;
  endDate:Date;



  constructor(private service:ExpenseclaimService,private route:Router) {
    this.employeeDetails = new Employee();
    this.claim=new ExpenseClaimModel();
    this.result=new ExpenseClaimModel();
    this.service.getProjectCode().subscribe(p=> this.projectIds =p);
    this.service.getExpenseCode().subscribe(p=> this.expenseIds=p);
    this.service.getFinanceCode().subscribe(p=> this.financeUserIds=p);
   }

  ngOnInit() {
  }

  addClaim(){
    this.claim.status="Applied";
    //this.claim.employeeId=this.employeeId;
    if(this.employeeDetails.empId==null){
      alert ("No Such Employee Found");
    }
    else{
    this.service.addExpenseClaim(this.claim).subscribe(exp=> this.result=exp);
    this.claim=new ExpenseClaimModel;
    this.result=new ExpenseClaimModel;
    }
  }

  showEmp(){
    this.employeeId=this.claim.employeeId;
    this.service.getEmployee(this.claim.employeeId).subscribe(emp=>{ 
      this.employeeDetails=emp;
      // if(this.employeeDetails==null){
      //   alert("No Employee With Such Id Found");
      // }
      // else{
        this.empExist=true;
      }
   // }
      );
  }

}
