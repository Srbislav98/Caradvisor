import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarBasedComponent } from './car-based.component';

describe('CarBasedComponent', () => {
  let component: CarBasedComponent;
  let fixture: ComponentFixture<CarBasedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarBasedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarBasedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
