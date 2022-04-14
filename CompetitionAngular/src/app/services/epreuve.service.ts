import { EvenementService } from './evenement.service';
import { Epreuve } from './../model/epreuve';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EpreuveService {
  private static URL: string = 'http://localhost:8080/compet/api/epreuve';
  constructor(
    private http: HttpClient,
    private evenementService: EvenementService
  ) {}

  public getAll(): Observable<Epreuve[]> {
    return this.http.get<Epreuve[]>(EpreuveService.URL);
  }
  public delete(id: number): Observable<void> {
    return this.http.delete<void>(EpreuveService.URL + '/' + id);
  }

  public get(id: number): Observable<Epreuve> {
    return this.http.get<Epreuve>(EpreuveService.URL + '/' + id);
  }

  public create(epreuve: any): Observable<any> {
    return new Observable<any>((observer) => {
      this.evenementService
        .getbyName(localStorage.getItem('evenement')!)
        .subscribe((result) => {
          this.http.post<any>(EpreuveService.URL + '/' + result.id, epreuve);
          observer.next(result);
        });
    });
  }

  public update(epreuve: any, id: number): Observable<any> {
    return this.http.put<any>(EpreuveService.URL + '/' + id, epreuve);
  }
}
