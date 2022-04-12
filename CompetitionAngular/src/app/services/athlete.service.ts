import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AthleteService {
  private static URL: string = 'http://localhost:8080/compet/api/athlete';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(AthleteService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(AthleteService.URL + '/' + id);
  }

  public get(id: number): Observable<any> {
    return this.http.get<any>(AthleteService.URL + '/' + id);
  }

  public getEpreuve(id: number): Observable<any> {
    return this.http.get<any>(AthleteService.URL + '/' + id + '/epreuve');
  }

  public getReservation(id: number): Observable<any> {
    return this.http.get<any>(AthleteService.URL + '/' + id + '/reservation');
  }

  public create(athlete: any): Observable<any> {
    let obj = {
      nom: athlete.nom,
      prenom: athlete.prenom,
      mail: athlete.mail,
      adresse: {
        numero: athlete.adresse.numero,
        voie: athlete.adresse.voie,
        ville: athlete.adresse.ville,
        cp: athlete.adresse.cp,
      },
      dateNaissance: athlete.dateNaissance,
    };

    return this.http.post<any>(AthleteService.URL, obj);
  }

  public update(athlete: any): Observable<any> {
    return this.http.put<any>(AthleteService.URL + '/' + athlete.id, athlete);
  }

  public InscriptionAthlete(compte: any): Observable<any> {
    return this.http.post('http://localhost:8080/compet/api/athlete', compte);
  }

  public findByEmail(email: string): Observable<any> {
    return this.http.get(
      'http://localhost:8080/compet/api/athlete/search/' + email
    );
  }
}
