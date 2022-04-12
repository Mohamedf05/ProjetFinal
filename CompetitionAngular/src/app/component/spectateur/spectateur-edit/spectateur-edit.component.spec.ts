import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpectateurEditComponent } from './spectateur-edit.component';

describe('SpectateurEditComponent', () => {
  let component: SpectateurEditComponent;
  let fixture: ComponentFixture<SpectateurEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpectateurEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpectateurEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
