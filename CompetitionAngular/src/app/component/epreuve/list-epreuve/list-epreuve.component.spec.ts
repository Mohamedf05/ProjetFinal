import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListEpreuveComponent } from './list-epreuve.component';

describe('ListEpreuveComponent', () => {
  let component: ListEpreuveComponent;
  let fixture: ComponentFixture<ListEpreuveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListEpreuveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListEpreuveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
