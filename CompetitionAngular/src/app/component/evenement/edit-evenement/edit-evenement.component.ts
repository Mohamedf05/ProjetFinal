import { StatutEvent } from '../../../model/statut-event';
import { EvenementService } from './../../../services/evenement.service';
import { Evenement } from '../../../model/evenement';
import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-evenement',
  templateUrl: './edit-evenement.component.html',
  styleUrls: ['./edit-evenement.component.css'],
})
export class EditEvenementComponent implements OnInit {
  currentDate: Date = new Date();
  form: FormGroup;
  evenement: Evenement = new Evenement();

  constructor(
    private aR: ActivatedRoute,
    private router: Router,
    private evenementService: EvenementService
  ) {
    this.form = new FormGroup({
      nom: new FormControl('', Validators.required),
      ville: new FormControl('', Validators.required),
      dateGroup: new FormGroup(
        {
          dateDebut: new FormControl('', Validators.required),
          dateFin: new FormControl('', Validators.required),
        },
        this.datesConsistent
      ),
    });
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.evenementService.get(params['id']).subscribe((e) => {
          this.evenement = e;
          this.form.get('nom')?.setValue(e.nom);
          this.form.get('dateGroup.dateDebut')?.setValue(e.dateDebut);
          this.form.get('dateGroup.dateFin')?.setValue(e.dateFin);
          this.form.get('ville')?.setValue(e.ville);
        });
      }
    });
  }

  submit(): void {
    if (
      new Date(this.form.get('dateGroup.dateFin')?.value).getTime() <
      this.currentDate.getTime()
    ) {
      this.evenement.statut = StatutEvent.Termine;
    } else if (
      new Date(this.form.get('dateGroup.dateDebut')?.value).getTime() <
      this.currentDate.getTime()
    ) {
      this.evenement.statut = StatutEvent.A_Venir;
    } else {
      this.evenement.statut = StatutEvent.En_Cours;
    }
    this.evenement.nom = this.form.get('nom')?.value;
    this.evenement.dateDebut = this.form.get('dateGroup.dateDebut')?.value;
    this.evenement.dateFin = this.form.get('dateGroup.dateFin')?.value;
    this.evenement.ville = this.form.get('ville')?.value;
    if (this.evenement.id) {
      this.evenementService.update(this.evenement).subscribe((result) => {
        this.router.navigateByUrl('/evenement/list');
      });
    } else {
      this.evenementService.create(this.evenement).subscribe((result) => {
        this.router.navigateByUrl('/evenement/list');
      });
    }
  }

  datesConsistent(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    let debut = new Date(group.get('dateDebut')?.value).getTime();
    let fin = new Date(group.get('dateFin')?.value).getTime();
    if (group.get('dateDebut')?.invalid || group.get('dateFin')?.invalid) {
      return null;
    }
    return debut >= fin ? { datesNotConsistent: true } : null;
  }
}
