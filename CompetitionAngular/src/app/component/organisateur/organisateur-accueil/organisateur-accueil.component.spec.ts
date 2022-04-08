import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganisateurAccueilComponent } from './organisateur-accueil.component';

describe('OrganisateurAccueilComponent', () => {
  let component: OrganisateurAccueilComponent;
  let fixture: ComponentFixture<OrganisateurAccueilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrganisateurAccueilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganisateurAccueilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
