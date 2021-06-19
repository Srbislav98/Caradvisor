import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  logForm: FormGroup;


  constructor(
    private fBuilder:FormBuilder,
    private router:Router,
    private authenticationService: AuthenticationService,
    private toastr: ToastrService
  ) {
    this.logForm = this.fBuilder.group({
      email: ["", [Validators.required]],
      password: ["", [Validators.required,Validators.minLength(3)]]
    });
   }

  ngOnInit():void {}

  logIn(){
		const auth: any = {};
		auth.username = this.logForm.value.email;
		auth.password = this.logForm.value.password;

		this.authenticationService.login(auth).subscribe(
			result => {
        this.toastr.success('Uspešna prijava!');
        //OVAKO DOBIJEM TOKEN
        localStorage.setItem('email',auth.username);
        localStorage.setItem('user', JSON.stringify(result));
        const item = localStorage.getItem('user');
		    const decodedItem = JSON.parse(item!);
        localStorage.setItem('accessToken', decodedItem.accessToken);
        const jwt: JwtHelperService = new JwtHelperService();
        const info = jwt.decodeToken(decodedItem.accessToken);
        localStorage.setItem('uloga', info['uloga']);
        console.log(info['uloga']);
				this.router.navigate(['']);
			},
			error => {
				this.toastr.error('Neuspešna prijava! Proverite korisničko ime i lozinku.');
			}
		);
	}

}
