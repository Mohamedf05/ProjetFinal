import { EpreuveService } from './../../../services/epreuve.service';
import { Epreuve } from './../../../model/epreuve';
import { Logement } from './../../../model/logement';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { StatutEvent } from './../../../model/statut-event';
import { Reservation } from './../../../model/reservation';
import { ReservationService } from './../../../services/reservation.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { LogementService } from 'src/app/services/logement.service';
import { Adresse } from 'src/app/model/adresse';

@Component({
  selector: 'app-reservation-edit',
  templateUrl: './reservation-edit.component.html',
  styleUrls: ['./reservation-edit.component.css'],
})
export class ReservationEditComponent implements OnInit {
  reservation: Reservation = new Reservation();
  logements: Logement[] = [];
  epreuves: Epreuve[] = [];

  adresse: Adresse[] | undefined;
  statut = StatutEvent;
  form: FormGroup;

  constructor(
    private aR: ActivatedRoute,
    private reservationService: ReservationService,
    private logementService: LogementService,
    private epreuveService: EpreuveService,
    private router: Router
  ) {
    this.form = new FormGroup({
      dateDebut: new FormControl('', Validators.required),
      dateFin: new FormControl('', Validators.required),
      logement: new FormControl(''),
      epreuve: new FormControl(''),
    });
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      this.logementService.getAll().subscribe((result) => {
        this.logements = result;
      });

      this.epreuveService.getAllEp().subscribe((result) => {
        this.epreuves = result;
      });

      if (params['id']) {
        this.reservationService.get(params['id']).subscribe((result) => {
          this.reservation = result;

          this.form.get('dateDebut')?.setValue(result.dateDebut);
          this.form.get('dateFin')?.setValue(result.dateFin);
          this.form.get('logement')?.setValue(result.logement?.id);
          this.form.get('epreuve')?.setValue(result.epreuve?.id);
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
      logement: {
        id: this.form.get('logement')?.value,
      },
      epreuve: {
        id: this.form.get('epreuve')?.value,
      },
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
