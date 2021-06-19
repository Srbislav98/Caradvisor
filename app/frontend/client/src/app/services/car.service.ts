import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { Car } from '../models/car';
import { AutomobilQuery } from '../models/automobilQuery';
import { Query } from '../models/query';

@Injectable({
	providedIn: 'root'
})
export class CarService {

  private headers = new HttpHeaders({'Content-Type': 'application/json'});

	constructor(
		private http: HttpClient
	) { }

	deleteCar(naziv: string): Observable<any> {
		return this.http.delete('http://localhost:8080/deleteCar/'+`${naziv}`, {headers:this.headers});
    }
	
	addCar(sub: Car): Observable<any> {
		const headeri=new HttpHeaders({
			'Content-Type': 'application/json'
		});
		return this.http.post('http://localhost:8080/create',sub);
	}
	chooseCarBased(sub: AutomobilQuery): Observable<any> {
		const headeri=new HttpHeaders({
			'Content-Type': 'application/json'
		});
		return this.http.post('http://localhost:8080/yourTopCars',sub);
	}
	choosePersonBased(sub: Query): Observable<any> {
		const headeri=new HttpHeaders({
			'Content-Type': 'application/json'
		});
		return this.http.post('http://localhost:8080/yourTopCarsBasedOnYou',sub);
	}
	public getByPage(page:number): Observable<any>{
        return this.http.get("http://localhost:8080/by-page?page="+page+"&size=5", {headers:this.headers})
	}
	public get(naziv:any):Observable<Car>{
        return this.http.get<Car>("http://localhost:8080/getCar/"+`${naziv}` , {headers:this.headers});
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