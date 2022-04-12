import { Logement } from './../model/logement';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LogementService {
  private static URL: string = 'http://localhost:8080/compet/api/logement';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<Logement[]> {
    return this.http.get<Logement[]>(LogementService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(LogementService.URL + '/' + id);
  }

  public get(id: number): Observable<Logement> {
    return this.http.get<Logement>(LogementService.URL + '/' + id);
  }

  public create(logement: any): Observable<any> {
    let obj = {
      nom: logement.nom,
      adresse: {
        numero: logement.adresse?.numero,
        voie: logement.adresse?.voie,
        ville: logement.adresse?.ville,
        cp: logement.adresse?.cp,
      },
      typeLogement: logement.typeLogement,
    };
    return this.http.post<any>(LogementService.URL, obj);
  }

  public update(logement: any, id: number): Observable<any> {
    return this.http.put<Logement>(LogementService.URL + '/' + id, logement);
  }
}
