import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EpreuveAccueiComponent } from './epreuve-accuei.component';

describe('EpreuveAccueiComponent', () => {
  let component: EpreuveAccueiComponent;
  let fixture: ComponentFixture<EpreuveAccueiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EpreuveAccueiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EpreuveAccueiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
