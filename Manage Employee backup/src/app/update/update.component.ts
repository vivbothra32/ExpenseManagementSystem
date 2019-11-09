import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { Observable } from 'rxjs';
import { ManageService } from '../manage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  designations : String[] = ['Analyst','Senior Analyst','Consultant','Associate Consultant','Senior Consultant','Manager','Senior Manager'];
  domains : String[] = ['Java', 'DevOps', 'AWS', 'Angular', 'SAP', 'Python'];
  employee : Employee;
  pan : string;
  domain : string;
  designation : string;
  employees : Employee[];
  employeeId : string;
  //employees : Observable<Employee[]>;
  emp : Observable<Employee>;
  constructor(private manageService: ManageService, private router: Router) {
    this.employee = new Employee();
   }

  ngOnInit() {
    this.emp = this.manageService.searchId(sessionStorage.getItem('empId'));
  }
  updateEmployee(){
    this.employee.empId = sessionStorage.getItem('empId');
    this.manageService.updateEmployee(this.employee).subscribe(data => {
      this.employee = data;
      //this.employees = this.employee;
      if(this.employee.empId == null){
        this.router.navigate(['update']);
        alert("Changes not updated!")
      }
      else{
          this.router.navigate(['search']);
          alert("Changes updated!");
      }
  });;
  }

  displayDetails(){
    this.manageService.searchId(this.employeeId).subscribe(data => this.employee = data);
  }

}
