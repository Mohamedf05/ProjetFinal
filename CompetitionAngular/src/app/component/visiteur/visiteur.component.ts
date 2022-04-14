import { ArticleService } from './../../services/article.service';
import { Article } from './../../model/article';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-visiteur',
  templateUrl: './visiteur.component.html',
  styleUrls: ['./visiteur.component.css'],
})
export class VisiteurComponent implements OnInit {
  articles: Article[] = [];
  nb: number = 0;

  constructor(private articleService: ArticleService) {}

  ngOnInit(): void {
    this.list();
    if (this.articles.length < 3) {
      this.nb = this.articles.length;
    } else {
      this.nb = 4;
    }
  }

  list() {
    this.articleService.getAll().subscribe((result) => {
      this.articles = result;
    });
  }
}
