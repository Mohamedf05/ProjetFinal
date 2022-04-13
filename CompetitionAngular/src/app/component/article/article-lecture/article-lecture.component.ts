import { ArticleService } from './../../../services/article.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Article } from './../../../model/article';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-article-lecture',
  templateUrl: './article-lecture.component.html',
  styleUrls: ['./article-lecture.component.css'],
})
export class ArticleLectureComponent implements OnInit {
  article: Article = new Article();

  constructor(
    private aR: ActivatedRoute,
    private articleService: ArticleService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.articleService.get(params['id']).subscribe((result) => {
          this.article = result;
        });
      }
    });
  }
}
