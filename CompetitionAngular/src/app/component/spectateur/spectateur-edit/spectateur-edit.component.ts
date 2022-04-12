import { Adresse } from './../../../model/adresse';
import { Compte } from './../../../model/compte';
import { SpectateurService } from './../../../services/spectateur.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-spectateur-edit',
  templateUrl: './spectateur-edit.component.html',
  styleUrls: ['./spectateur-edit.component.css'],
})
export class SpectateurEditComponent implements OnInit {
  compte: Compte = new Compte();
  adresse: Adresse = new Adresse();

  constructor(
    private aR: ActivatedRoute,
    private spectateurService: SpectateurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.spectateurService.get(params['id']).subscribe((result) => {
          this.compte = result;
          this.adresse = result.adresse;
        });
      }
      this.compte.adresse = this.adresse;
    });
  }

  save() {
    if (this.compte.id) {
      this.spectateurService.update(this.compte).subscribe((result) => {
        this.goList();
      });
    } else {
      this.spectateurService.create(this.compte).subscribe((result) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigateByUrl('/spectateur');
  }
}
