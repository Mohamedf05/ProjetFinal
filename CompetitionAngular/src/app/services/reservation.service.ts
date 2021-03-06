import { StatutEvent } from './../model/statut-event';
import { Reservation } from './../model/reservation';
import { Adresse } from './../model/adresse';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ReservationService {
  private static URL: string = 'http://localhost:8080/compet/api/reservation';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<Reservation[]> {
    return this.http.get<any[]>(ReservationService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(ReservationService.URL + '/' + id);
  }

  public get(id: number): Observable<Reservation> {
    return this.http.get<any>(ReservationService.URL + '/' + id);
  }

  public getEpreuve(id: number): Observable<Reservation> {
    return this.http.get<any>(ReservationService.URL + '/' + id + '/epreuve');
  }

  public create(reservation: any): Observable<Reservation> {
    let obj = {
      statut: reservation.statut,
      date: reservation.date,
      heure: reservation.heure,
      logement: {
        id: reservation.logement.id,
      },
      epreuve: {
        id: reservation.epreuve.id,
      },
      dateDebut: reservation.dateDebut,
      dateFin: reservation.dateFin,
    };

    return this.http.post<Reservation>(ReservationService.URL, obj);
  }

  public update(reservation: any, id: number): Observable<any> {
    return this.http.put<Reservation>(
      ReservationService.URL + '/' + id,
      reservation
    );
  }
}
