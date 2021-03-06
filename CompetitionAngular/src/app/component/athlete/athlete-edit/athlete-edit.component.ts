import { Adresse } from './../../../model/adresse';
import { Compte } from './../../../model/compte';
import { AthleteService } from './../../../services/athlete.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-athlete-edit',
  templateUrl: './athlete-edit.component.html',
  styleUrls: ['./athlete-edit.component.css'],
})
export class AthleteEditComponent implements OnInit {
  compte: Compte = new Compte();
  adresse: Adresse = new Adresse();

  constructor(
    private aR: ActivatedRoute,
    private athleteService: AthleteService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (localStorage.getItem('profil')) {
      this.compte = JSON.parse(localStorage.getItem('compte')!);
    }
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.athleteService.get(params['id']).subscribe((result) => {
          this.compte = result;
          this.adresse = result.adresse;
        });
      }
      this.compte.adresse = this.adresse;
    });
  }

  save() {
    if (this.compte.id) {
      this.athleteService.update(this.compte).subscribe((result) => {
        this.goList();
      });
    } else {
      this.athleteService.create(this.compte).subscribe((result) => {
        this.goList();
      });
    }
  }

  goList() {
    if (localStorage.getItem('profil')) {
      localStorage.removeItem('profil');
      localStorage.clear();
      this.router.navigateByUrl('/home');
    } else this.router.navigateByUrl('/athlete');
  }
  annuler() {
    if (localStorage.getItem('profil')) {
      this.router.navigateByUrl('/profil');
    } else this.router.navigateByUrl('/athlete');
  }
}
