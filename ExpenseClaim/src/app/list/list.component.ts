import { Component, OnInit } from '@angular/core';
import { ExpenseClaimModel } from '../Model/ExpenseClaim';
import { ExpenseclaimService } from '../expenseclaim/expenseclaim.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  expenseClaims:ExpenseClaimModel;

  constructor(private service:ExpenseclaimService,private route:Router) {
    this.expenseClaims=new ExpenseClaimModel;
  }

  ngOnInit() {
   // this.expenseClaims=new ExpenseClaimModel;
  }
  listClaim() {
    this.service.listExpenseClaims(this.expenseClaims.claimId).subscribe(p => this.expenseClaims =p);
  }

}
