import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ArticleService {
  private static URL: string = 'http://localhost:8080/compet/api/article';
  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(ArticleService.URL);
  }

  public get(id: number): Observable<any> {
    return this.http.get<any>(`${ArticleService.URL}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<any>(`${ArticleService.URL}/${id}`);
  }

  public create(article: any): Observable<any> {
    return this.http.post(ArticleService.URL, article);
  }

  public update(article: any): Observable<any> {
    return this.http.put<any>(ArticleService.URL + '/' + article.id, article);
  }

  baseApiUrl = '/api/thumbnail-upload';
  // Returns an observable
  upload(file: any, id: any): Observable<any> {
    // Create form data
    const formData = new FormData();

    // Store form name as "file" with file data
    formData.append('file', file, file.name);

    // Make http post request over api
    // with formData as req
    return this.http.post(`${ArticleService.URL}/${id}`, formData);
  }
}
