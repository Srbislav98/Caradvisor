import { Component, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Subscription } from 'rxjs';
import { AutomobilQuery } from 'src/app/models/automobilQuery';
import { Boja } from 'src/app/models/boja';
import { Car } from 'src/app/models/car';
import { Gorivo } from 'src/app/models/gorivo';
import { Karoserija } from 'src/app/models/karoserija';
import { CarService } from 'src/app/services/car.service';
import { DataService } from 'src/app/services/data.service';
import { FotografijaService } from 'src/app/services/fotografija.service';

@Component({
  selector: 'app-car-based',
  templateUrl: './car-based.component.html',
  styleUrls: ['./car-based.component.scss']
})
export class CarBasedComponent implements OnInit {
  keys1 = Object.keys;
  symbols1 = Karoserija;
  keys2 = Object.keys;
  symbols2 = Gorivo;
  keys3 = Object.keys;
  symbols3 = Boja;
  car = new AutomobilQuery(1,"",Karoserija.DZIP,0,0,Gorivo.BENZIN,false,0,Boja.BELA);
  regForm:FormGroup;
  cars: Car[] | undefined;
  subscription: Subscription;
  constructor(
    private data: DataService,
    private fBuilder: FormBuilder,
    private router: Router,
    private carService:CarService,
    private fotoService:FotografijaService,
    private toastr: ToastrService
  ) { 
    this.regForm = this.fBuilder.group({
      marka: ["", [Validators.required,Validators.minLength(1)]],
      karoserija: [undefined, [Validators.required]],
      cena: ["", [Validators.required,Validators.minLength(1)]],
      godiste: ["", [Validators.required,Validators.minLength(1)]],
      gorivo: [undefined, [Validators.required]],
      klima: [undefined, [Validators.required]],
      kubikaza: ["", [Validators.required,Validators.minLength(1)]],
      boja: [undefined, [Validators.required]],
    });
  }

  ngOnInit(): void {
    this.subscription = this.data.currentMessage.subscribe(cars => this.cars = cars);
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  regIn(){
    this.car.marka=this.regForm.value["marka"];
    this.car.karoserija=this.regForm.value["karoserija"];
    this.car.cena=this.regForm.value["cena"];
    this.car.godiste=this.regForm.value["godiste"];
    this.car.gorivo=this.regForm.value["gorivo"];
    this.car.klima=this.regForm.value["klima"];
    this.car.kubikaza=this.regForm.value["kubikaza"];
    this.car.boja=this.regForm.value["boja"];
    this.carService.chooseCarBased(this.car).subscribe(
      dataa=>{
        this.cars=dataa as Car[];
        console.log(this.cars);
        this.data.changeMessage(this.cars);
        this.router.navigate(['results']);
      },
      error=>{
        this.toastr.error("Unsuccessful car choosing.");
      }
    )
  }
}
