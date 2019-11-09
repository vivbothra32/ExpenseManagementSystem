import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { FormsModule } from '@angular/forms';
import { CarComponent } from './app.carcomponent';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule
    ],
    declarations: [
        AppComponent,
        CarComponent
		], 
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }