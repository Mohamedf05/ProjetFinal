import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionAthleteComponent } from './inscription-athlete.component';

describe('InscriptionAthleteComponent', () => {
  let component: InscriptionAthleteComponent;
  let fixture: ComponentFixture<InscriptionAthleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionAthleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionAthleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
