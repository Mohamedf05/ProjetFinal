import { OrganisateurService } from './../../../services/organisateur.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-organisateur-reservation',
  templateUrl: './organisateur-reservation.component.html',
  styleUrls: ['./organisateur-reservation.component.css'],
})
export class OrganisateurReservationComponent implements OnInit {
  reservations: any[] = [];
  constructor(
    private aR: ActivatedRoute,
    private organisateurService: OrganisateurService
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.organisateurService
          .getReservation(params['id'])
          .subscribe((result) => {
            this.reservations = result;
            console.log(result);
          });
      }
    });
  }
}
