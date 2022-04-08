import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JournalisteAccueilComponent } from './journaliste-accueil.component';

describe('JournalisteAccueilComponent', () => {
  let component: JournalisteAccueilComponent;
  let fixture: ComponentFixture<JournalisteAccueilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JournalisteAccueilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JournalisteAccueilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
