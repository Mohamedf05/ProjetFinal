import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JournalisteEditComponent } from './journaliste-edit.component';

describe('JournalisteEditComponent', () => {
  let component: JournalisteEditComponent;
  let fixture: ComponentFixture<JournalisteEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JournalisteEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JournalisteEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
