import { Evenement } from '../model/evenement';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EvenementService {
  private static URL: string = 'http://localhost:8080/compet/api/evenement';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL);
  }
  public delete(id: number): Observable<void> {
    return this.http.delete<void>(EvenementService.URL + '/' + id);
  }

  public get(id: number): Observable<Evenement> {
    return this.http.get<Evenement>(EvenementService.URL + '/' + id);
  }

  public create(evenement: Evenement): Observable<Evenement> {
    return this.http.post<Evenement>(
      EvenementService.URL + '/1',
      this.evenementToJson(evenement)
    );
  }

  public update(evenement: Evenement): Observable<Evenement> {
    return this.http.put<Evenement>(
      EvenementService.URL + '/' + evenement.id,
      this.evenementToJson(evenement)
    );
  }

  private evenementToJson(evenement: Evenement): any {
    let obj = {
      nom: evenement.nom,
      dateDebut: evenement.dateDebut,
      dateFin: evenement.dateFin,
      ville: evenement.ville,
      statut: evenement.statut,
    };
    return obj;
  }
}
