import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root',
})
export class SpectateurService {
  private static URL: string = 'http://localhost:8080/compet/api/spectateur';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(SpectateurService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(SpectateurService.URL + '/' + id);
  }

  public get(id: number): Observable<any> {
    return this.http.get<any>(SpectateurService.URL + '/' + id);
  }

  public getReservation(id: number): Observable<any> {
    return this.http.get<any>(
      SpectateurService.URL + '/' + id + '/reservation'
    );
  }

  public create(spectateur: any): Observable<any> {
    let obj = {
      nom: spectateur.nom,
      prenom: spectateur.prenom,
      mail: spectateur.mail,
      adresse: {
        numero: spectateur.adresse.numero,
        voie: spectateur.adresse.voie,
        ville: spectateur.adresse.ville,
        cp: spectateur.adresse.cp,
      },
      dateNaissance: spectateur.dateNaissance,
    };

    return this.http.post<any>(SpectateurService.URL, obj);
  }

  public update(spectateur: any): Observable<any> {
    return this.http.put<any>(
      SpectateurService.URL + '/' + spectateur.id,
      spectateur
    );
  }
  public InscriptionSpectateur(compte: any): Observable<any> {
    return this.http.post(
      'http://localhost:8080/compet/api/spectateur',
      compte
    );
  }

  public findByEmail(email: string): Observable<any> {
    return this.http.get(
      'http://localhost:8080/compet/api/spectateur/search/' + email
    );
  }
}
