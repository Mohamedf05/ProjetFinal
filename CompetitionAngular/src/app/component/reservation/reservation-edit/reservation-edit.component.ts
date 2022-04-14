import { Time } from '@angular/common';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { StatutEvent } from './../../../model/statut-event';
import { Reservation } from './../../../model/reservation';
import { ReservationService } from './../../../services/reservation.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reservation-edit',
  templateUrl: './reservation-edit.component.html',
  styleUrls: ['./reservation-edit.component.css'],
})
export class ReservationEditComponent implements OnInit {
  reservation: Reservation = new Reservation();
  statut = StatutEvent;
  form: FormGroup;

  constructor(
    private aR: ActivatedRoute,
    private reservationService: ReservationService,
    private router: Router
  ) {
    this.form = new FormGroup({
      dateDebut: new FormControl('', Validators.required),
      dateFin: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.reservationService.get(params['id']).subscribe((result) => {
          this.reservation = result;

          this.form.get('dateDebut')?.setValue(result.dateDebut);
          this.form.get('dateFin')?.setValue(result.dateFin);
          // this.form.get('date')?.setValue(result.date);

          // this.form.get('heure')?.setValue(result.heure);
          // this.form.get('statut')?.setValue(result?.statut);
        });
      }
    });
  }

  save() {
    let obj = {
      statut: this.form.get('statut')?.value,
      date: this.form.get('date')?.value,
      heure: this.form.get('heure')?.value,
      dateDebut: this.form.get('dateDebut')?.value,
      dateFin: this.form.get('dateFin')?.value,
    };
    if (this.reservation.id) {
      this.reservationService
        .update(obj, this.reservation.id)
        .subscribe((result) => {
          this.goList();
        });
    } else {
      this.reservationService.create(obj).subscribe((result) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigateByUrl('/reservation');
  }
}
