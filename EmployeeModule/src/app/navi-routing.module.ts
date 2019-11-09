import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginEmployeeComponent } from './login-employee/login-employee.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { SearchEmployeeComponent } from './search-employee/search-employee.component';

const routes: Routes = [
  {path:"",redirectTo:"/add", pathMatch:"full"},
  //{path:"login",component: LoginEmployeeComponent},
  {path:"add",component: AddEmployeeComponent},
  {path:"search",component: SearchEmployeeComponent},
  {path:"*",redirectTo:"/add", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
