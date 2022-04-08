import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EvenementAccueilComponent } from './evenement-accueil.component';

describe('EvenementAccueilComponent', () => {
  let component: EvenementAccueilComponent;
  let fixture: ComponentFixture<EvenementAccueilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EvenementAccueilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EvenementAccueilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
