import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TerrainAccueilComponent } from './terrain-accueil.component';

describe('TerrainAccueilComponent', () => {
  let component: TerrainAccueilComponent;
  let fixture: ComponentFixture<TerrainAccueilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TerrainAccueilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TerrainAccueilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
