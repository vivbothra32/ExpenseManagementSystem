import { Component, OnInit } from '@angular/core';
import { ExpenseClaimModel } from '../Model/ExpenseClaim';
import { ExpenseclaimService } from '../expenseclaim/expenseclaim.service';
import { Router } from '@angular/router';
import { Employee } from '../Model/Employee';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  claim:ExpenseClaimModel;
  result:ExpenseClaimModel;
  employeeDetails:Employee;
  empExist:boolean = false;
  employeeId:String;
  projectIds:number[];
  expenseIds:number[];
  clientIds:number[] = [301,302,303];
  financeUserIds:number[];



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

  updateClaim(){
    this.claim.status="Applied";
   // this.claim.employeeId=this.employeeId;
    this.service.updateExpenseClaim(this.claim).subscribe(exp=> this.result=exp);
    this.claim=new ExpenseClaimModel;
    this.result=new ExpenseClaimModel;

  }

  showEmp(){
    this.employeeId=this.claim.employeeId;
    this.service.getEmployee(this.claim.employeeId).subscribe(emp=>this.employeeDetails=emp);
  }

}

