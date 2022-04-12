import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncaseComponent } from './incase.component';

describe('IncaseComponent', () => {
  let component: IncaseComponent;
  let fixture: ComponentFixture<IncaseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IncaseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IncaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
