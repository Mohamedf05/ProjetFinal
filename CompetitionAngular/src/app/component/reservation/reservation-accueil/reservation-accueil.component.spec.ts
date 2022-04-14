import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationAccueilComponent } from './reservation-accueil.component';

describe('ReservationAccueilComponent', () => {
  let component: ReservationAccueilComponent;
  let fixture: ComponentFixture<ReservationAccueilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReservationAccueilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationAccueilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
