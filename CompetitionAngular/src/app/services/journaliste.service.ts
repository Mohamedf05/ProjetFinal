import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root',
})
export class JournalisteService {
  private static URL: string = 'http://localhost:8080/compet/api/journaliste';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(JournalisteService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(JournalisteService.URL + '/' + id);
  }

  public get(id: number): Observable<any> {
    return this.http.get<any>(JournalisteService.URL + '/' + id);
  }

  public getReservation(id: number): Observable<any> {
    return this.http.get<any>(
      JournalisteService.URL + '/' + id + '/reservation'
    );
  }

  public create(journaliste: any): Observable<any> {
    let obj = {
      nom: journaliste.nom,
      prenom: journaliste.prenom,
      mail: journaliste.mail,
      adresse: {
        numero: journaliste.adresse.numero,
        voie: journaliste.adresse.voie,
        ville: journaliste.adresse.ville,
        cp: journaliste.adresse.cp,
      },
      entreprise: journaliste.entreprise,
    };

    return this.http.post<any>(JournalisteService.URL, obj);
  }

  public update(journaliste: any): Observable<any> {
    return this.http.put<any>(
      JournalisteService.URL + '/' + journaliste.id,
      journaliste
    );
  }
  public InscriptionJournaliste(compte: any): Observable<any> {
    return this.http.post(
      'http://localhost:8080/compet/api/journaliste',
      compte
    );
  }

  public findByEmail(email: string): Observable<any> {
    return this.http.get(
      'http://localhost:8080/compet/api/journaliste/search/' + email
    );
  }
}
