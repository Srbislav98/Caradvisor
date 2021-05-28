import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
	providedIn: 'root'
})
export class AuthenticationService {
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

	constructor(
		private http: HttpClient
	) { }

	public registerUser(user:User):Observable<any> {
        return this.http.post<any>("http://localhost:8080/auth/signup",user)
    }
	login(auth: any): Observable<any> {
		return this.http.post('http://localhost:8080/auth/login', {username: auth.username, password: auth.password}, {headers: this.headers, responseType: 'json'});
	}
	isLoggedIn(): boolean {
		if (!localStorage.getItem('user')) {
				return false;
		}
		return true;
    }
}