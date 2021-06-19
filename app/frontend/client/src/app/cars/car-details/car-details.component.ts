import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { ToastrService } from 'ngx-toastr';
import { Boja } from 'src/app/models/boja';
import { Car } from 'src/app/models/car';
import { Fotografija } from 'src/app/models/fotografija';
import { Gorivo } from 'src/app/models/gorivo';
import { Karoserija } from 'src/app/models/karoserija';
import { CarService } from 'src/app/services/car.service';
import { FotografijaService } from 'src/app/services/fotografija.service';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.scss']
})
export class CarDetailsComponent implements OnInit {
  car = new Car("","",Karoserija.DZIP,0,0,Gorivo.BENZIN,false,0,Boja.BELA,0);
  temp:string|null;
  klimica:string|null;
  uloga = "";
  fotografija=new Fotografija(0,"",null,"/assets/img/auto.jpg");

  constructor(
    private fBuilder: FormBuilder,
    private router: Router,
    private carService:CarService,
    private fotoService:FotografijaService,
    private route:ActivatedRoute,
    private toastr: ToastrService
  ) { 
    this.temp=this.route.snapshot.paramMap.get('nazivAuta');
  }

  ngOnInit(): void {
    this.carService.get(this.temp).subscribe(
      result => {
        
        // this.kP = new KulturnaPonuda(Number(result.id), result.naziv, result.adresa, result.opis, Number(result.idt), Number(result.idLokacije));
        this.car=result;
        if (this.car.klima){
          this.klimica="DA";
        }else{
          this.klimica="NE";
        }
        this.fotoService.get(this.temp).subscribe(
          result => {
              console.log(result);
              if(result.lokacijaFajl!=null){
                this.fotografija=result;
                result.lokacijaFajl=result.lokacijaFajl.split("src")[1];
              }
            },
            (error:any)=>{
              console.log(error);
            });
      },
      (error:any)=>{
        console.log(error);
      });
      this.uloga = localStorage.getItem('uloga');
  }
  natrag():void{
    this.router.navigate(['']);
  }
  Obrisi():void{
    this.carService.deleteCar(this.temp).subscribe(
			res => {
        this.toastr.success("Uspešno obrisan autombil.");
        this.router.navigate(['']);
        //this.router.navigate(['kulturne-ponude']);
      },
      error => {
				this.toastr.error('Neuspešno obrisan automobil. Nemate dozvolu da obrišete ovaj automobil.');
			}
    );
  }
}
