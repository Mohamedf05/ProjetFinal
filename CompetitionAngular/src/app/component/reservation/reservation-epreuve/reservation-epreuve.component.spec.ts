import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationEpreuveComponent } from './reservation-epreuve.component';

describe('ReservationEpreuveComponent', () => {
  let component: ReservationEpreuveComponent;
  let fixture: ComponentFixture<ReservationEpreuveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReservationEpreuveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationEpreuveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
