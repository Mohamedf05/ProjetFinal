import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { JournalisteService } from 'src/app/services/journaliste.service';

@Component({
  selector: 'app-journaliste-reservation',
  templateUrl: './journaliste-reservation.component.html',
  styleUrls: ['./journaliste-reservation.component.css'],
})
export class JournalisteReservationComponent implements OnInit {
  reservations: any[] = [];
  constructor(
    private aR: ActivatedRoute,
    private journalisteService: JournalisteService
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.journalisteService
          .getReservation(params['id'])
          .subscribe((result) => {
            this.reservations = result;
            console.log(result);
          });
      }
    });
  }
}
