import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/models/user';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  regForm:FormGroup;
  user:User=new User(1,"","","","");

  constructor(
    private fBuilder: FormBuilder,
    private router: Router,
    private toastr: ToastrService,
    private authService:AuthenticationService
    ) {
      this.regForm = this.fBuilder.group({
        //email: ["", [Validators.required, Validators.email]],
        username: ["", [Validators.required]],
        ime: ["", [Validators.required]],
        prezime: ["", [Validators.required]],
        password: ["", [Validators.required,Validators.minLength(6)]]
      });
     }
  
    ngOnInit():void {}
  
    regIn(){
     // this.user.email=this.regForm.value["email"];
      this.user.username=this.regForm.value["username"];
      this.user.firstname=this.regForm.value["ime"];
      this.user.lastname=this.regForm.value["prezime"];
      this.user.password=this.regForm.value["password"];
      this.authService.registerUser(this.user).subscribe(
        data=>{
          this.toastr.success('Successful registration. You can now log in.');
          this.regForm.reset();
          this.router.navigate(['/login']);
        },
        error=>{
          this.toastr.error("Unsuccessful registration. Email/Username is already in use.");
        }
      )
    }
  }
