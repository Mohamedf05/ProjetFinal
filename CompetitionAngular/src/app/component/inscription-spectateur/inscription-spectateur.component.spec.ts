import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionSpectateurComponent } from './inscription-spectateur.component';

describe('InscriptionSpectateurComponent', () => {
  let component: InscriptionSpectateurComponent;
  let fixture: ComponentFixture<InscriptionSpectateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionSpectateurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionSpectateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
