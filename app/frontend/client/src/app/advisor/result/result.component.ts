import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Car } from 'src/app/models/car';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.scss']
})
export class ResultComponent implements OnInit {
  cars: Car[] | undefined;
  subscription: Subscription;

  constructor(
    private data: DataService
  ) { }

  ngOnInit(): void {
    this.subscription = this.data.currentMessage.subscribe(cars => this.cars = cars);
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
