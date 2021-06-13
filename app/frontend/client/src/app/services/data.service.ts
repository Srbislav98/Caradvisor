import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Car } from '../models/car';

@Injectable()
export class DataService {
  
  private arr : Car[] = [];
  private messageSource = new BehaviorSubject(this.arr);
  currentMessage = this.messageSource.asObservable();

  constructor() { }

  changeMessage(cars: Car[]) {
    this.messageSource.next(cars)
  }

}