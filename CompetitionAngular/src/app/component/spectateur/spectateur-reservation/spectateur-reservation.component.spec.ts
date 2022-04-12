import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpectateurReservationComponent } from './spectateur-reservation.component';

describe('SpectateurReservationComponent', () => {
  let component: SpectateurReservationComponent;
  let fixture: ComponentFixture<SpectateurReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpectateurReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpectateurReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
