import { TypeTerrain } from './../../../model/type-terrain';
import { Discipline } from './../../../model/discipline';
import { Terrain } from './../../../model/terrain';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TerrainService } from 'src/app/services/terrain.service';

@Component({
  selector: 'app-terrain-edit',
  templateUrl: './terrain-edit.component.html',
  styleUrls: ['./terrain-edit.component.css'],
})
export class TerrainEditComponent implements OnInit {
  form: FormGroup;
  terrain: Terrain = new Terrain();
  disciplines = Discipline;
  typeTerrains = TypeTerrain;

  disciplinesChecker = [
    { Discipline: 'Athletisme', checked: false },
    { Discipline: 'Baseball', checked: false },
    { Discipline: 'Basketball', checked: false },
    { Discipline: 'Boxe', checked: false },
    { Discipline: 'Cyclisme', checked: false },
    { Discipline: 'Equitation', checked: false },
    { Discipline: 'Handball', checked: false },
    { Discipline: 'Football', checked: false },
    { Discipline: 'Judo', checked: false },
    { Discipline: 'Natation', checked: false },
    { Discipline: 'Skate', checked: false },
    { Discipline: 'Tennis', checked: false },
  ];

  constructor(
    private aR: ActivatedRoute,
    private terrainService: TerrainService,
    private router: Router
  ) {
    this.form = new FormGroup({
      nom: new FormControl('', Validators.required),
      numero: new FormControl('', Validators.required),
      voie: new FormControl('', Validators.required),
      ville: new FormControl('', Validators.required),
      codePostal: new FormControl('', Validators.required),
      selectedDisciplines: new FormArray([], Validators.required),
      typeTerrain: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.terrainService.get(params['id']).subscribe((result) => {
          this.terrain = result;
          this.form.get('nom')?.setValue(result.nom);
          this.form.get('numero')?.setValue(result.adresse.numero);
          this.form.get('voie')?.setValue(result.adresse.voie);
          this.form.get('ville')?.setValue(result.adresse.ville);
          this.form.get('codePostal')?.setValue(result.adresse.cp);
          this.form.get('typeTerrain')?.setValue(result.typeTerrain);
        });
      }
    });
  }

  onCheckBoxChange(event: any) {
    const disciplines = this.form.controls['selectedDisciplines'] as FormArray;
    if (event.target.checked) {
      disciplines.push(new FormControl(event.target.value));
    } else {
      const index = disciplines.controls.findIndex(
        (x) => x.value === event.target.value
      );
      disciplines.removeAt(index);
    }
  }

  submit() {
    let terrain = {
      id: this.terrain.id,
      nom: this.form.get('nom')?.value,
      adresse: {
        numero: this.form.get('numero')?.value,
        voie: this.form.get('voie')?.value,
        cp: this.form.get('codePostal')?.value,
        ville: this.form.get('ville')?.value,
      },
      disciplines: this.form.get('selectedDisciplines')?.value,
      typeTerrain: this.form.get('typeTerrain')?.value,
    };
    this.terrainService.create(terrain).subscribe((ok) => {
      this.router.navigateByUrl('/terrain');
    });
  }
}
