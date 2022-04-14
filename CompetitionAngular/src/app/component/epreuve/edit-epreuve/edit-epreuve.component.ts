import { Evenement } from './../../../model/evenement';
import { EvenementService } from './../../../services/evenement.service';
import { Terrain } from './../../../model/terrain';
import { TerrainService } from './../../../services/terrain.service';
import { Discipline } from './../../../model/discipline';
import { EpreuveService } from './../../../services/epreuve.service';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';
import { Epreuve } from './../../../model/epreuve';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-epreuve',
  templateUrl: './edit-epreuve.component.html',
  styleUrls: ['./edit-epreuve.component.css'],
})
export class EditEpreuveComponent implements OnInit {
  form: FormGroup;
  epreuve: Epreuve = new Epreuve();
  disciplines = Discipline;
  terrains: Terrain[] | undefined = [];

  constructor(
    private aR: ActivatedRoute,
    private router: Router,
    private epreuveService: EpreuveService,
    private terrainService: TerrainService
  ) {
    this.form = new FormGroup({
      participant: new FormControl('', Validators.required),
      date: new FormControl('', Validators.required),
      discipline: new FormControl('', Validators.required),
      terrain: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.epreuveService.get(params['id']).subscribe((e) => {
          this.epreuve = e;
          this.form.get('participant')?.setValue(e.maxParticipant);
          this.form.get('discipline')?.setValue(e.discipline);
          this.form.get('terrain')?.setValue(e.terrain?.id);
          this.form.get('date')?.setValue(e.date);
        });
      }
    });
    this.terrainService.getAll().subscribe((ok) => {
      this.terrains = ok;
    });
  }

  datesConsistent(control: AbstractControl): ValidationErrors | null | any {
    let group = control as FormGroup;
    let dateControl = new Date(group.get('date')?.value).getTime();

    if (group.get('date')?.invalid) {
      return null;
    }

    let evenement = JSON.parse(localStorage.getItem('evenement')!);
    let dateDebut = new Date(evenement.dateDebut);
    let dateFin = new Date(evenement.dateFin);
    console.log(new Date(evenement.dateFin));
    console.log(dateControl);
    return dateControl > dateFin?.getTime()! ||
      dateControl < dateDebut?.getTime()!
      ? { dateNotConsistent: true }
      : null;
  }

  submit(): void {
    let obj: any;
    this.terrainService
      .get(this.form.get('terrain')?.value)
      .subscribe((result) => {
        let objTerrain = result;
        obj = {
          maxParticipant: this.form.get('participant')?.value,
          date: this.form.get('date')?.value,
          discipline: this.form.get('discipline')?.value,
          terrain: objTerrain,
        };

        if (this.epreuve.id) {
          this.epreuveService
            .update(obj, this.epreuve.id)
            .subscribe((): void => {
              this.router.navigateByUrl('/epreuve');
            });
        } else {
          this.epreuveService.create(obj).subscribe((): void => {
            this.router.navigateByUrl('/epreuve');
          });
        }
      });
  }

  annuler(id: number | undefined): void {
    this.aR.params.subscribe((param) => {
      if (param['id']) {
        this.router.navigateByUrl('/epreuve/consulter/' + id);
      } else this.router.navigateByUrl('/epreuve');
    });
  }
}
