import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AthleteEpreuveComponent } from './athlete-epreuve.component';

describe('AthleteEpreuveComponent', () => {
  let component: AthleteEpreuveComponent;
  let fixture: ComponentFixture<AthleteEpreuveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AthleteEpreuveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AthleteEpreuveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
