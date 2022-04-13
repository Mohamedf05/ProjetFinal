import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleAccueilComponent } from './article-accueil.component';

describe('ArticleAccueilComponent', () => {
  let component: ArticleAccueilComponent;
  let fixture: ComponentFixture<ArticleAccueilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArticleAccueilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleAccueilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
