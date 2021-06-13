import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CarBasedComponent } from './advisor/car-based/car-based.component';
import { CarChooseComponent } from './advisor/car-choose/car-choose.component';
import { PersonBasedComponent } from './advisor/person-based/person-based.component';
import { ResultComponent } from './advisor/result/result.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { CarAddComponent } from './cars/car-add/car-add.component';
import { CarDetailsComponent } from './cars/car-details/car-details.component';
import { LoginGuard } from './guards/login.service';
import { RoleGuard } from './guards/role.service';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {
    path : '',
    component : HomeComponent
  },
  {
    path : 'car-detaljno/:nazivAuta',
    component : CarDetailsComponent
  },
  {
    path : 'login',
    component : LoginComponent,
		canActivate: [LoginGuard]
  },
  {
    path : 'addCar',
    component : CarAddComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_ADMIN'}
  },
  {
    path : 'chooseCar',
    component : CarChooseComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_USER'}
  },
  {
    path : 'carBased',
    component : CarBasedComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_USER'}
  },
  {
    path : 'personBased',
    component : PersonBasedComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_USER'}
  },
  {
    path : 'results',
    component : ResultComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_USER'}
  },
  {
    path : 'registration',
    component : SignupComponent,
		canActivate: [LoginGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
