import { Adresse } from './../../../model/adresse';
import { Compte } from './../../../model/compte';
import { ActivatedRoute, Router } from '@angular/router';
import { OrganisateurService } from './../../../services/organisateur.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-organisateur-edit',
  templateUrl: './organisateur-edit.component.html',
  styleUrls: ['./organisateur-edit.component.css'],
})
export class OrganisateurEditComponent implements OnInit {
  compte: Compte = new Compte();
  adresse: Adresse = new Adresse();

  constructor(
    private aR: ActivatedRoute,
    private organisateurService: OrganisateurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.organisateurService.get(params['id']).subscribe((result) => {
          this.compte = result;
          this.adresse = result.adresse;
        });
      }
      this.compte.adresse = this.adresse;
    });
  }

  save() {
    if (this.compte.id) {
      this.organisateurService.update(this.compte).subscribe((result) => {
        this.goList();
      });
    } else {
      this.organisateurService.create(this.compte).subscribe((result) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigateByUrl('/organisateur');
  }
}
