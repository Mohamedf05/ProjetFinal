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
    this.list();
  }

  list() {
    this.reservationService.getAll().subscribe((result) => {
      this.reservations = result;
    });
  }

  delete(id: number) {
    this.reservationService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }
}
