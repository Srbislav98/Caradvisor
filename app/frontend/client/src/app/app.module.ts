import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Interceptor } from './interceptors/intercept.service';
import { NavbarComponent } from './navbar/navbar.component';
import { ToastrModule } from 'ngx-toastr';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { HomeComponent } from './home/home.component';
import { CarListComponent } from './cars/car-list/car-list.component';
import { CarTableComponent } from './cars/car-table/car-table.component';
import { CarDetailsComponent } from './cars/car-details/car-details.component';
import { PaginationComponent } from './pagination/pagination.component';
import { CarAddComponent } from './cars/car-add/car-add.component';
import { CarChooseComponent } from './advisor/car-choose/car-choose.component';
import { PersonBasedComponent } from './advisor/person-based/person-based.component';
import { CarBasedComponent } from './advisor/car-based/car-based.component';
import { ResultComponent } from './advisor/result/result.component';
import { DataService } from './services/data.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    NavbarComponent,
    HomeComponent,
    CarListComponent,
    CarTableComponent,
    CarDetailsComponent,
    PaginationComponent,
    CarAddComponent,
    CarChooseComponent,
    PersonBasedComponent,
    CarBasedComponent,
    ResultComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    MatToolbarModule,
    MatButtonModule,
    MatIconModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true},DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
