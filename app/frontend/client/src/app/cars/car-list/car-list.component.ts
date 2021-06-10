import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Car } from 'src/app/models/car';
import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.scss']
})
export class CarListComponent implements OnInit {
  regForm1:FormGroup;
  pageSize: number;
  currentPage: number;
  totalSize: number;
  carList:Car[] | undefined;
  uloga: any;
  trazi1:boolean = false;
  trazim:string ="";

	constructor(
		private carService: CarService,
		private fBuilder: FormBuilder,
	) {
		this.pageSize = 2;
		this.currentPage = 1;
		this.totalSize = 1;
		this.regForm1 = this.fBuilder.group({
			podatak: [""]
      });
    this.uloga = localStorage.getItem('uloga');
	}

	changePage(newPage: number) {
    if(!this.trazi1) {
      this.carService.getByPage(newPage - 1).subscribe(
        res => {

          this.carList = res.content as Car[];
          this.totalSize = Number(res.totalElements);
        }
      );
    } else {
      if(this.trazim.length!=0 && this.trazi1){
        this.carService.searchAllByPage(this.trazim, newPage - 1, this.pageSize).subscribe(
        res=>{
          this.carList = res.body.content as Car[];
          //alert(this.subList.length);
          //alert(this.totalSize);
          this.totalSize = Number(res.body.totalElements);
        }
        );
      }
      }

	}
	ngOnInit() {
    this.regForm1.reset();
    this.trazi1=false;
    //this.trazim="";
		this.carService.getByPage(this.currentPage - 1).subscribe(
			res => {
				console.log(res.content);
				console.log(res.totalPages);
				this.carList = res.content as Car[];
        this.totalSize = Number(res.totalElements);
			}
		);
	}
	regIn(){
		if(this.regForm1.value["podatak"].length!=0){
      this.trazi1 = true;
      this.trazim=this.regForm1.value["podatak"];
			this.carService.searchAllByPage(this.trazim,this.currentPage - 1, this.pageSize).subscribe(
			res=>{
				this.carList = res.body.content as Car[];
				//alert(this.subList.length);
				//alert(this.totalSize);
        this.totalSize = Number(res.body.totalElements);
        const locationIds = new Array<number>();
			}
      );
		}
  }
}
