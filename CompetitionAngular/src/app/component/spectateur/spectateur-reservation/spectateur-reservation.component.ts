import { SpectateurService } from './../../../services/spectateur.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-spectateur-reservation',
  templateUrl: './spectateur-reservation.component.html',
  styleUrls: ['./spectateur-reservation.component.css'],
})
export class SpectateurReservationComponent implements OnInit {
  reservations: any[] = [];
  constructor(
    private aR: ActivatedRoute,
    private spectateurService: SpectateurService
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.spectateurService
          .getReservation(params['id'])
          .subscribe((result) => {
            this.reservations = result;
            console.log(result);
          });
      }
    });
  }
}
