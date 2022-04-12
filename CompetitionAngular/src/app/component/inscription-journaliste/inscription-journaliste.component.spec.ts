import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionJournalisteComponent } from './inscription-journaliste.component';

describe('InscriptionJournalisteComponent', () => {
  let component: InscriptionJournalisteComponent;
  let fixture: ComponentFixture<InscriptionJournalisteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionJournalisteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionJournalisteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
