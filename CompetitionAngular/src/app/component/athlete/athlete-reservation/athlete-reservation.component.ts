import { AthleteService } from './../../../services/athlete.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-athlete-reservation',
  templateUrl: './athlete-reservation.component.html',
  styleUrls: ['./athlete-reservation.component.css'],
})
export class AthleteReservationComponent implements OnInit {
  reservations: any[] = [];
  constructor(
    private aR: ActivatedRoute,
    private athleteService: AthleteService
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.athleteService.getReservation(params['id']).subscribe((result) => {
          this.reservations = result;
          console.log(result);
        });
      }
    });
  }
}
