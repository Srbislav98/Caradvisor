import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-car-choose',
  templateUrl: './car-choose.component.html',
  styleUrls: ['./car-choose.component.scss']
})
export class CarChooseComponent implements OnInit {

  constructor(
    private router: Router,
    private route:ActivatedRoute,
  ) { }

  ngOnInit(): void {
  }

  carBased() {
    this.router.navigateByUrl('/carBased');
  }
  personBased() {
    this.router.navigateByUrl('/personBased');
  }

}
