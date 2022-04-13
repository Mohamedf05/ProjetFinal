import { Compte } from './../model/compte';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root',
})
export class OrganisateurService {
  private static URL: string = 'http://localhost:8080/compet/api/organisateur';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(OrganisateurService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(OrganisateurService.URL + '/' + id);
  }

  public get(id: number): Observable<any> {
    return this.http.get<any>(OrganisateurService.URL + '/' + id);
  }
  public getByLogin(login: string): Observable<Compte> {
    return this.http.get<Compte>(OrganisateurService.URL + '/login/' + login);
  }

  public getReservation(id: number): Observable<any> {
    return this.http.get<any>(
      OrganisateurService.URL + '/' + id + '/reservation'
    );
  }

  public create(organisateur: any): Observable<any> {
    let obj = {
      nom: organisateur.nom,
      prenom: organisateur.prenom,
      mail: organisateur.mail,
      adresse: {
        numero: organisateur.adresse.numero,
        voie: organisateur.adresse.voie,
        ville: organisateur.adresse.ville,
        cp: organisateur.adresse.cp,
      },
      raisonSoc: organisateur.raisonSoc,
    };

    return this.http.post<any>(OrganisateurService.URL, obj);
  }

  public update(organisateur: any): Observable<any> {
    return this.http.put<any>(
      OrganisateurService.URL + '/' + organisateur.id,
      organisateur
    );
  }
  public InscriptionOrganisateur(compte: any): Observable<any> {
    return this.http.post(
      'http://localhost:8080/compet/api/organisateur',
      compte
    );
  }

  public findByEmail(email: string): Observable<any> {
    return this.http.get(
      'http://localhost:8080/compet/api/organisateur/search/' + email
    );
  }
}
