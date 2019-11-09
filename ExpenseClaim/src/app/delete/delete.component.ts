import { Component, OnInit } from '@angular/core';
import { ExpenseClaimModel } from '../Model/ExpenseClaim';
import { ExpenseclaimService } from '../expenseclaim/expenseclaim.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  claim:ExpenseClaimModel;
  deleteStatus:boolean;
  expenseClaims:ExpenseClaimModel;
  constructor(private service:ExpenseclaimService,private route:Router) {
    this.claim=new ExpenseClaimModel();
    this.expenseClaims=new ExpenseClaimModel();
   }

  ngOnInit() {
  }
  deleteClaim(){
    this.service.deleteExpenseClaim(this.claim.claimId).subscribe(data=>{
      this.deleteStatus=data;
      console.log(this.deleteStatus);
      if(this.deleteStatus==false)
        alert("not deleted!");
      else{
        
        alert("Deleted");
        this.route.navigate['list'];
      }
    });
    this.route.navigate['list'];
   
  }
  listClaim() {
    this.service.listExpenseClaims(this.claim.claimId).subscribe(p => this.expenseClaims =p);
  }
}
