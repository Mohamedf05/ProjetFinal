import { ArticleService } from './../../../services/article.service';
import { Article } from './../../../model/article';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-article-accueil',
  templateUrl: './article-accueil.component.html',
  styleUrls: ['./article-accueil.component.css'],
})
export class ArticleAccueilComponent implements OnInit {
  articles: Article[] = [];

  constructor(private articleService: ArticleService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.articleService.getAll().subscribe((result) => {
      this.articles = result;
    });
  }

  delete(id: number) {
    this.articleService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }
}
