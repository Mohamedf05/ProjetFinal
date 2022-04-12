import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JournalisteReservationComponent } from './journaliste-reservation.component';

describe('JournalisteReservationComponent', () => {
  let component: JournalisteReservationComponent;
  let fixture: ComponentFixture<JournalisteReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JournalisteReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JournalisteReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
