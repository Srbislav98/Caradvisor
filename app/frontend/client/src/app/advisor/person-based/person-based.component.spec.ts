import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonBasedComponent } from './person-based.component';

describe('PersonBasedComponent', () => {
  let component: PersonBasedComponent;
  let fixture: ComponentFixture<PersonBasedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PersonBasedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonBasedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
