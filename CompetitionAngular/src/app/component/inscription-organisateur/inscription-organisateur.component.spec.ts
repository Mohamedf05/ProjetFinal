import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionOrganisateurComponent } from './inscription-organisateur.component';

describe('InscriptionOrganisateurComponent', () => {
  let component: InscriptionOrganisateurComponent;
  let fixture: ComponentFixture<InscriptionOrganisateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionOrganisateurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionOrganisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
