import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { SearchEmployeeComponent } from './search-employee/search-employee.component';
import { UpdateBankDetailsComponent } from './update-bank-details/update-bank-details.component';
import { UpdatePasswordComponent } from './update-password/update-password.component';
import { ListEmployeeComponent } from './list-employee/list-employee.component';
import { NaviRoutingModule } from './navi-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AddEmployeeComponent,
    SearchEmployeeComponent,
    UpdateBankDetailsComponent,
    UpdatePasswordComponent,
    ListEmployeeComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, 
    FormsModule, NaviRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
