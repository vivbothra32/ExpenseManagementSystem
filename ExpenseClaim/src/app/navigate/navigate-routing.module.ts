import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddComponent } from '../add/add.component';
import { ListComponent } from '../list/list.component';
import { UpdateComponent } from '../update/update.component';
import { DeleteComponent } from '../delete/delete.component';


const routes: Routes = [
  {path:'',redirectTo:'/expenseclaim',pathMatch:'full'},
  {path:'expenseclaim',component:AddComponent},
  {path:'list',component:ListComponent},
  
  {path:'update',component:UpdateComponent},
  {path:'delete',component:DeleteComponent},
  {path:'**',redirectTo:'/expenseclaim',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NavigateRoutingModule { }
