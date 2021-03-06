import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Fotografija } from '../models/fotografija';
@Injectable({ providedIn:'root'})
export class FotografijaService{
    private readonly path = "http://localhost:8080/fotografije";
    private headers = new HttpHeaders({'Content-Type':'application/json'})
    constructor(
        private http:HttpClient
    ){}

    public get(naziv:string):Observable<Fotografija>{
        return this.http.get<Fotografija>(this.path+"/getByNaziv"+`/${naziv}`,{headers:this.headers});
    }
    public getByCulturalId(id:any):Observable<Fotografija>{
        return this.http.get<Fotografija>(this.path+"/getByCulturalId"+`/${id}`,{headers:this.headers});
    }

    public getAll():Observable<Fotografija[]>{
        return this.http.get<Fotografija[]>(this.path);
    }

    public getByPage(page:number):any{
        return this.http.get(this.path+"/by-page?page="+page+"&size=2",{headers:this.headers});
    }

    public update(recenzija:Fotografija, id:number){
        return this.http.put(this.path+"/update"+`/${id}`,recenzija,{headers:this.headers});
    }

    public createForCar(fajl:File,naziv:string){
        const formData:FormData=new FormData();
        formData.append('File',fajl,fajl.name);
        return this.http.post(this.path+"/create/car-naziv"+`/${naziv}`,formData);
    }

    public createForRec(fajl:File,id:number,id2:number){
        const formData:FormData=new FormData();
        formData.append('File',fajl,fajl.name);
        return this.http.post(this.path+"/createForRec/kulturna"+`/${id}`+"/registrovani"+`/${id2}`,formData);
    }

    public delete(id:number){
        return this.http.delete(this.path+"/delete/"+`${id}`);
    }
}