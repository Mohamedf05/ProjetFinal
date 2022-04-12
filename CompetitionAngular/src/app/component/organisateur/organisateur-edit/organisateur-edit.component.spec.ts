import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganisateurEditComponent } from './organisateur-edit.component';

describe('OrganisateurEditComponent', () => {
  let component: OrganisateurEditComponent;
  let fixture: ComponentFixture<OrganisateurEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrganisateurEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganisateurEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
