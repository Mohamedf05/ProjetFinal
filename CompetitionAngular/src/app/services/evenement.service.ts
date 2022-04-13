import { OrganisateurService } from './organisateur.service';
import { Evenement } from '../model/evenement';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EvenementService {
  private static URL: string = 'http://localhost:8080/compet/api/evenement';

  constructor(
    private http: HttpClient,
    private organisateurService: OrganisateurService
  ) {}

  public getAll(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL);
  }
  public delete(id: number): Observable<void> {
    return this.http.delete<void>(EvenementService.URL + '/' + id);
  }

  public get(id: number): Observable<Evenement> {
    return this.http.get<Evenement>(EvenementService.URL + '/' + id);
  }
  public getbyName(nom: string): Observable<Evenement> {
    return this.http.get<Evenement>(EvenementService.URL + '/nom/' + nom);
  }

  public create(evenement: Evenement): Observable<Evenement> {
    return this.http.post<Evenement>(
      EvenementService.URL + '/',
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
