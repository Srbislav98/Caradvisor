import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Car } from 'src/app/models/car';
import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-car-table',
  templateUrl: './car-table.component.html',
  styleUrls: ['./car-table.component.scss']
})
export class CarTableComponent implements OnInit {
  @Input() cars: Car[] | undefined;
  uloga: any;

	constructor(
    private toastr: ToastrService,
    private router:Router,
    private carService: CarService,
  ) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => {
      return false;
    };
    this.uloga = localStorage.getItem('uloga');
  }

  ngOnInit() {}

  Obrisi(auto: Car): void {
    this.carService.deleteCar(auto.id).subscribe(
			res => {
        this.toastr.success("Succcessful deleted car.");
        //this.router.navigate(['']);
        this.router.navigate(['cars']);
      },
      error => {
				this.toastr.error('Unsucccessful deleted car.');
			}
    );
  }
}
