import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AddComponent } from './add/add.component';
import { ListComponent } from './list/list.component';
import { UpdateComponent } from './update/update.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NavigateRoutingModule } from './navigate/navigate-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpErrorInterceptor } from './http-interceptor';
import { DeleteComponent } from './delete/delete.component';

@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    ListComponent,
    UpdateComponent,
    DeleteComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NavigateRoutingModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpErrorInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
