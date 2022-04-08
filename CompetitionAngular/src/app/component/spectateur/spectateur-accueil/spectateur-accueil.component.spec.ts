import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpectateurAccueilComponent } from './spectateur-accueil.component';

describe('SpectateurAccueilComponent', () => {
  let component: SpectateurAccueilComponent;
  let fixture: ComponentFixture<SpectateurAccueilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpectateurAccueilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpectateurAccueilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
