import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AthleteReservationComponent } from './athlete-reservation.component';

describe('AthleteReservationComponent', () => {
  let component: AthleteReservationComponent;
  let fixture: ComponentFixture<AthleteReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AthleteReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AthleteReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
