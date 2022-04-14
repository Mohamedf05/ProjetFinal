import { Compte } from './../model/compte';
import { Epreuve } from './../model/epreuve';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EpreuveService {
  private static URL: string = 'http://localhost:8080/compet/api/epreuve';
  constructor(private http: HttpClient) {}

  public getAll(): Observable<Epreuve[]> {
    return this.http.get<Epreuve[]>(
      EpreuveService.URL +
        '/evenement/' +
        JSON.parse(localStorage.getItem('evenement')!).id
    );
  }

  public getAthletes(): Observable<Compte[]> {
    return this.http.get<Compte[]>(
      EpreuveService.URL +
        '/participants/' +
        JSON.parse(localStorage.getItem('epreuve')!).id
    );
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(EpreuveService.URL + '/' + id);
  }

  public get(id: number): Observable<Epreuve> {
    return this.http.get<Epreuve>(EpreuveService.URL + '/' + id);
  }

  public create(epreuve: any): Observable<any> {
    return this.http.post<any>(
      EpreuveService.URL +
        '/' +
        JSON.parse(localStorage.getItem('evenement')!).id,
      epreuve
    );
  }

  public update(epreuve: any, id: number): Observable<any> {
    return this.http.put<any>(EpreuveService.URL + '/' + id, epreuve);
  }
}
