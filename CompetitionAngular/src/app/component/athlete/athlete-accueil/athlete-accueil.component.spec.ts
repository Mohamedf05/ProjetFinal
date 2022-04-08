import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AthleteAccueilComponent } from './athlete-accueil.component';

describe('AthleteAccueilComponent', () => {
  let component: AthleteAccueilComponent;
  let fixture: ComponentFixture<AthleteAccueilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AthleteAccueilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AthleteAccueilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
