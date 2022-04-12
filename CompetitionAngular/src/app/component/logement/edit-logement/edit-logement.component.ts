import { Adresse } from './../../../model/adresse';
import { TypeLogement } from './../../../model/type-logement';
import { LogementService } from 'src/app/services/logement.service';
import { Logement } from './../../../model/logement';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-logement',
  templateUrl: './edit-logement.component.html',
  styleUrls: ['./edit-logement.component.css'],
})
export class EditLogementComponent implements OnInit {
  logement: Logement = new Logement();
  types = TypeLogement;
  adresse: Adresse = new Adresse();
  form: FormGroup;

  constructor(
    private aR: ActivatedRoute,
    private router: Router,
    private logementService: LogementService
  ) {
    this.form = new FormGroup({
      nom: new FormControl('', Validators.required),
      adresse: new FormGroup({
        numero: new FormControl('', Validators.required),
        voie: new FormControl('', Validators.required),
        ville: new FormControl('', Validators.required),
        cp: new FormControl('', Validators.required),
      }),
      types: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.logementService.get(params['id']).subscribe((result) => {
          this.logement = result;
          this.form.get('nom')?.setValue(result.nom);
          this.form.get('adresse.numero')?.setValue(result.adresse?.numero);
          this.form.get('adresse.voie')?.setValue(result.adresse?.voie);
          this.form.get('adresse.ville')?.setValue(result.adresse?.ville);
          this.form.get('adresse.cp')?.setValue(result.adresse?.cp);
          this.form.get('types')?.setValue(result?.typeLogement);
        });
      }
    });
  }

  goList() {
    this.router.navigateByUrl('/logement');
  }

  byTypes(objA: TypeLogement, objB: TypeLogement) {
    if (objA && objB) {
      return objA == objB;
    }
    return false;
  }

  submit() {
    let o = {
      nom: this.form.get('nom')?.value,
      adresse: {
        numero: this.form.get('adresse.numero')?.value,
        voie: this.form.get('adresse.voie')?.value,
        ville: this.form.get('adresse.ville')?.value,
        cp: this.form.get('adresse.cp')?.value,
      },
      typeLogement: this.form.get('types')?.value,
    };
    if (this.logement.id) {
      this.logementService.update(o, this.logement.id).subscribe((ok) => {
        this.router.navigateByUrl('/logement');
      });
    } else {
      this.logementService.create(o).subscribe((ok) => {
        this.router.navigateByUrl('/logement');
      });
    }
  }
}
