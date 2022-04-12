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
  currentDate: Date = new Date();
  form: FormGroup;
  epreuve: Epreuve = new Epreuve();
  disciplines = Discipline;
  terrains: Terrain[] | undefined = [];

  idEvenement: Number = 0;
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
    this.terrainService.getAll().subscribe((ok) => {
      this.terrains = ok;
    });
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.epreuveService.get(params['id']).subscribe((e) => {
          this.epreuve = e;
          this.form.get('participant')?.setValue(e.maxParticipant);
          this.form.get('date')?.setValue(e.date);
          this.form.get('discipline')?.setValue(e.discipline);
          this.form.get('terrain')?.setValue(e.terrain);
        });
      }
      if (params['idEvenement']) {
        this.idEvenement = params['idEvenement'];
      }
    });
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
          this.epreuveService.update(obj, this.epreuve.id).subscribe((ok) => {
            this.router.navigateByUrl('/epreuve/list');
          });
        } else {
          this.aR.params.subscribe((params) => {
            if (params['idEvenement']) {
              this.epreuveService
                .create(obj, params['idEvenement'])
                .subscribe((ok) => {
                  this.router.navigateByUrl('/epreuve/list');
                });
            }
          });
        }
      });
  }
}
