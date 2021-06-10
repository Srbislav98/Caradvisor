import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
	providedIn: 'root'
})
export class CarService {

  private headers = new HttpHeaders({'Content-Type': 'application/json'});

	constructor(
		private http: HttpClient
	) { }

	deleteCar(id2: number): Observable<any> {
		const headeri=new HttpHeaders({
			'Content-Type': 'application/json'
		});
		return this.http.delete('http://localhost:8080/api/cars/delete'+`/${id2}`, {headers:headeri});
    }
	public getByPage(page:number): Observable<any>{
        return this.http.get("http://localhost:8080/by-page?page="+page+"&size=2", {headers:this.headers})
	}
	searchAllByPage(content:string,page: number, size: number): Observable<any> {
		let queryParams = {};

		queryParams = {
			headers:new HttpHeaders({
				'Content-Type': 'application/json'
			}),
			observe: 'response',
			params: new HttpParams()
				.set('page', String(page))
				.append('size', String(size)),
		};
		const headeri=new HttpHeaders({
			
			'Content-Type': 'application/json'
		});
		return this.http.get('http://localhost:8080/filter-by-content-page'+`/${content}`, queryParams);
  	}
}