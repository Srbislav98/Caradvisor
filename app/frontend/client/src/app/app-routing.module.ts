import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { CarAddComponent } from './cars/car-add/car-add.component';
import { LoginGuard } from './guards/login.service';
import { RoleGuard } from './guards/role.service';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {
    path : '',
    component : HomeComponent
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
