import { ReservationService } from './../../../services/reservation.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reservation-accueil',
  templateUrl: './reservation-accueil.component.html',
  styleUrls: ['./reservation-accueil.component.css'],
})
export class ReservationAccueilComponent implements OnInit {
  reservations: any[] = [];
  constructor(private reservationService: ReservationService) {}

  ngOnInit(): void {
    console.log(this.clientId);
    this.list();
   
  }

  list() {
    this.reservationService.getAll().subscribe((result) => {
      this.reservations = result;
      console.log(this.reservations);
    });
  }

  delete(id: number) {
    this.reservationService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }

  get clientId() {
    if (localStorage.getItem('compte')) {
      return JSON.parse(localStorage.getItem('compte')!).id;
    }
  }
}
