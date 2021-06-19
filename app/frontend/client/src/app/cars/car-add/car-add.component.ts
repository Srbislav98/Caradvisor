import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Boja } from 'src/app/models/boja';
import { Car } from 'src/app/models/car';
import { Gorivo } from 'src/app/models/gorivo';
import { Karoserija } from 'src/app/models/karoserija';
import { CarService } from 'src/app/services/car.service';
import { FotografijaService } from 'src/app/services/fotografija.service';

@Component({
  selector: 'app-car-add',
  templateUrl: './car-add.component.html',
  styleUrls: ['./car-add.component.scss']
})
export class CarAddComponent implements OnInit {
  keys1 = Object.keys;
  symbols1 = Karoserija;
  keys2 = Object.keys;
  symbols2 = Gorivo;
  keys3 = Object.keys;
  symbols3 = Boja;
  car = new Car("","",Karoserija.DZIP,0,0,Gorivo.BENZIN,false,0,Boja.BELA,0);
  regForm:FormGroup;
  fileToUpload:any=null;
  imgUrl:any;
  constructor(
    private fBuilder: FormBuilder,
    private router: Router,
    private carService:CarService,
    private fotoService:FotografijaService,
    private toastr: ToastrService
  ) { 
    this.regForm = this.fBuilder.group({
      naziv: ["", [Validators.required,Validators.minLength(1)]],
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
  }

  regIn(){
    this.car.naziv=this.regForm.value["naziv"];
    this.car.marka=this.regForm.value["marka"];
    this.car.karoserija=this.regForm.value["karoserija"];
    this.car.cena=this.regForm.value["cena"];
    this.car.godiste=this.regForm.value["godiste"];
    this.car.gorivo=this.regForm.value["gorivo"];
    this.car.klima=this.regForm.value["klima"];
    this.car.kubikaza=this.regForm.value["kubikaza"];
    this.car.boja=this.regForm.value["boja"];
    this.carService.addCar(this.car).subscribe(
      dataa=>{
        if(this.fileToUpload!==null && this.car.naziv!==null){
          this.fotoService.createForCar(this.fileToUpload,this.car.naziv).subscribe(
            data=>{
              console.log("MONAKO");
              this.toastr.success('Uspešno dodat automobil.');
              this.router.navigate(['']);
            },
            error=>{
              console.log("ANGOLA");
              this.toastr.error("Neuspešno dodata fotografija. Proverite da li je to stvarno fotografija.");
            }
          )
          }else{
            console.log("KENIJA");
            this.toastr.success('Uspešno dodat automobil.');
            this.router.navigate(['']);
          }
      },
      error=>{
        this.toastr.error("Neuspešno dodat automobil. Proverite unesene podatke da li su validni (naziv automobila treba biti jedinstven,fotografija mora biti validna).");
      }
    )
  }
  handleFileInput(target:any){
    let files=target.files;
    this.fileToUpload=files.item(0);
    var reader = new FileReader();
    reader.readAsDataURL(files[0]);
    reader.onload=(_event)=>{
      this.imgUrl=reader.result;
      console.log("pegazela");
      console.log(this.imgUrl);
    }
  }
}
