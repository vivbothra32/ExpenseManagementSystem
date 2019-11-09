import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AddComponent } from './add/add.component';
import { ListComponent } from './list/list.component';
import { SearchComponent } from './search/search.component';
import { NavigationRoutingModule } from './navigation/navigation-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddComponent,
    ListComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    NavigationRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
