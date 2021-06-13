import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarChooseComponent } from './car-choose.component';

describe('CarChooseComponent', () => {
  let component: CarChooseComponent;
  let fixture: ComponentFixture<CarChooseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarChooseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarChooseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
