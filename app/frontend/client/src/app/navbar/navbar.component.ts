  
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  role: any;

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  getRole(): string {
    const item = localStorage.getItem('user');

		if (!item) {
			this.role = undefined;
			return this.role;
		}
    const jwt: JwtHelperService = new JwtHelperService();
    const decodedItem = JSON.parse(item!);
    const info = jwt.decodeToken(decodedItem.accessToken);
    this.role=info['uloga'];
    return this.role;
  }

  goToHome() {
    this.router.navigate(['']);
  }

  goToLogIn() {
    //localStorage.removeItem('user');
    //localStorage.removeItem('uloga');
    this.router.navigate(['/login']);
  }

  goToRegistration() {
    this.router.navigate(['/registration']);
  }

  goToProfile() {
    this.router.navigateByUrl('/profil');
  }
  addCar() {
    this.router.navigateByUrl('/addCar');
  }
  chooseCar() {
    this.router.navigateByUrl('/chooseCar');
  }

  logOut() {
    //this.authenticationService.logout().subscribe(
		//	result => {
        localStorage.removeItem('user');
        localStorage.removeItem('accessToken');
        localStorage.removeItem('uloga');
				this.toastr.success('Uspešno ste se odjavili!');
				this.router.navigate(['login']);
		//	},
		//	error => {
		//		this.toastr.error('Some error. Try again.');
		//	}
		//);
  }

}
