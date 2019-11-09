import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { ListComponent } from '../list/list.component';
import { AddComponent } from '../add/add.component';
import { SearchComponent } from '../search/search.component';

const routes: Routes = [
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:'home',component:HomeComponent},
  {path:'list',component:ListComponent},
  {path:'add',component:AddComponent},
  {path:'search',component:SearchComponent},
  {path:'**',redirectTo:'/home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NavigationRoutingModule { }
