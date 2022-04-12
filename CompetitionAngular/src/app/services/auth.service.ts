import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  public authentication(login: string, password: string): Observable<any> {
    let httpHeaders: HttpHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa(login + ':' + password),
    });

    return this.http.get<any>('http://localhost:8080/compet/api/auth', {
      headers: httpHeaders,
      responseType: 'text' as 'json',
    });
  }

  isAutenticated(): boolean {
    return localStorage.getItem('login') ? true : false;
  }
}
