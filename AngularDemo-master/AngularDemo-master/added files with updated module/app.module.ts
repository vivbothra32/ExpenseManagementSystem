/* author Tejaswini, Aditya, Mayank
description : main app module
Created on: 19/10/2019
Last modified on: 23/10/2019
 */
import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { HttpClientModule } from '@angular/common/http';


import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './app.errorcomponent';
import { AddBusComponent } from './app.addbuscomponent';
import { ShowBusesComponent } from './app.showbusescomponent';
import { AdminHomeComponent } from './app.adminhomecomponent';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpErrorInterceptor } from './app.httperrorinterceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ToastrModule } from 'ngx-toastr';
import {LoginComponent} from './app.logincomponent'
import { AddBookingComponent } from './app.addbookingcomponent';
import { ViewBookingsComponent } from './app.viewbookingscomponent';
import { CancelBookingComponent } from './app.cancelbookingcomponent';
import { CustomerHomeComponent } from './app.customerhomecomponent';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { ShowRunningBusesComponent } from './app.showrunningbusescomponent';
import { DatePipe } from '@angular/common'
import { AddPassengerComponent } from './app.addpassengercomponent';


import { AddUserComponent } from './app.addusercomponent';
import { ViewAllUsersComponent } from './app.viewalluserscomponent';
import { HomeComponent } from './app.homecomponent';
import { LogoutComponent } from './app.logoutcomponent';
import { AuthGuardService } from './_service/app.authguardservice';
import {ContactUsComponent} from './app.contactuscomponent';
import {HelpComponent} from './app.helpcomponent'


//{path: 'show/:text', component: ShowComponent},
const myroutes: Routes = [
    
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'adminhome', component: AdminHomeComponent,canActivate:[AuthGuardService]},
    { path: 'addbus', component: AddBusComponent,canActivate:[AuthGuardService]},
    { path: 'showbuses', component: ShowBusesComponent,canActivate:[AuthGuardService]},
    {path:'login',component:LoginComponent},
    {path:'logout',component:LogoutComponent,canActivate:[AuthGuardService]},
    { path: 'register', component: AddUserComponent },
    {path:'addbooking',component: AddBookingComponent,canActivate:[AuthGuardService]},
    {path:'viewbookings',component: ViewBookingsComponent,canActivate:[AuthGuardService]},
    {path:'cancelbooking/:bookingId',component: CancelBookingComponent,canActivate:[AuthGuardService]},
    {path:'customerhome',component: CustomerHomeComponent,canActivate:[AuthGuardService]},
    {path:'searchrunningbuses/:src/:dest/:journeydate',component: ShowRunningBusesComponent,canActivate:[AuthGuardService]},
    {path:'addpassenger/:busTransactionId',component:AddPassengerComponent,canActivate:[AuthGuardService]},
   { path: 'adduser', component: AddUserComponent },
    { path: 'showusers', component: ViewAllUsersComponent },
    { path: '**', component: ErrorComponent }
];

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        RouterModule.forRoot(myroutes),
        BrowserAnimationsModule, // required animations module
        ToastrModule.forRoot(), // ToastrModule added
        NgxPaginationModule,
        NgbModule.forRoot(),
        ConfirmationPopoverModule.forRoot({ confirmButtonType: 'danger' })

    ],
    declarations: [
        AppComponent,
        HomeComponent,
        AddBusComponent,
        ShowBusesComponent,
        AdminHomeComponent,
        LoginComponent,
        LogoutComponent,
        ErrorComponent,
        AddBookingComponent, ViewBookingsComponent, CancelBookingComponent,
        CustomerHomeComponent, ShowRunningBusesComponent, AddPassengerComponent, 
        AddUserComponent, 
        ViewAllUsersComponent, ContactUsComponent, HelpComponent
    ],
    providers: [{
        provide: HTTP_INTERCEPTORS,
        useClass: HttpErrorInterceptor,
        multi: true
    },DatePipe],
    entryComponents: [],
    bootstrap: [AppComponent]
})

export class AppModule { }