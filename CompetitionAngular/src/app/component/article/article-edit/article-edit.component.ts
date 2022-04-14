import { HttpClient } from '@angular/common/http';
import { ArticleService } from './../../../services/article.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Article } from './../../../model/article';
import { FormGroup, FormControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-article-edit',
  templateUrl: './article-edit.component.html',
  styleUrls: ['./article-edit.component.css'],
})
export class ArticleEditComponent implements OnInit {
  form: FormGroup;
  article: Article = new Article();
  constructor(
    private aR: ActivatedRoute,
    private articleService: ArticleService,
    private router: Router,
    private http: HttpClient
  ) {
    this.form = new FormGroup({
      titre: new FormControl(''),
      corps: new FormControl(''),
    });
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.articleService.get(params['id']).subscribe((result) => {
          this.article = result;
          this.form.get('titre')?.setValue(result.titre);
          this.form.get('corps')?.setValue(result.corps);
        });
      }
    });
  }

  submit() {
    if (this.article.id) {
      let article = {
        id: this.article.id,
        titre: this.form.get('titre')?.value,
        corps: this.form.get('corps')?.value,
        image: this.article.image,
        journaliste: JSON.parse(localStorage.getItem('compte')!),
      };
      this.articleService.update(article).subscribe((ok) => {
        this.router.navigateByUrl('/article');
      });
    } else {
      let article = {
        titre: this.form.get('titre')?.value,
        corps: this.form.get('corps')?.value,
        image: 'assets/images/logo3.jpg',
        journaliste: JSON.parse(localStorage.getItem('compte')!),
      };
      this.articleService.create(article).subscribe((ok) => {
        this.router.navigateByUrl('/article');
      });
    }
  }

  // Variable to store shortLink from api response
  shortLink: string = '';
  loading: boolean = false; // Flag variable
  file: File = {
    name: '',
    lastModified: 0,
    webkitRelativePath: '',
    size: 0,
    type: '',
    arrayBuffer: function (): Promise<ArrayBuffer> {
      throw new Error('Function not implemented.');
    },
    slice: function (start?: number, end?: number, contentType?: string): Blob {
      throw new Error('Function not implemented.');
    },
    stream: function (): ReadableStream<any> {
      throw new Error('Function not implemented.');
    },
    text: function (): Promise<string> {
      throw new Error('Function not implemented.');
    },
  }; // Variable to store file

  onChange(event: any) {
    this.file = event.target.files[0];
  }
  onUpload() {
    this.loading = !this.loading;
    let id: any = this.article.id;
    this.articleService.upload(this.file, id).subscribe((event: any) => {
      if (typeof event === 'object') {
        // Short link via api response
        //this.shortLink = event.link;

        this.loading = false; // Flag variable
        this.router.navigateByUrl('/article');
      }
    });
  }
}
