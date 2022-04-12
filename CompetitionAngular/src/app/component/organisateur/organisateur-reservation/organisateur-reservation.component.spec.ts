import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganisateurReservationComponent } from './organisateur-reservation.component';

describe('OrganisateurReservationComponent', () => {
  let component: OrganisateurReservationComponent;
  let fixture: ComponentFixture<OrganisateurReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrganisateurReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganisateurReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
