import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { AddEmployeeComponent } from './app.addemployeecomponent';
import { ShowEmployeeComponent } from './app.showemployeecomponent';
import { SearchEmployeeComponent } from './app.searchemployeecomponent';



@NgModule({
    imports: [
        BrowserModule
        
    ],
    declarations: [
        AppComponent,AddEmployeeComponent,ShowEmployeeComponent,SearchEmployeeComponent
		], 
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }