import { Adresse } from './../../../model/adresse';
import { Compte } from './../../../model/compte';
import { ActivatedRoute, Router } from '@angular/router';
import { JournalisteService } from './../../../services/journaliste.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-journaliste-edit',
  templateUrl: './journaliste-edit.component.html',
  styleUrls: ['./journaliste-edit.component.css'],
})
export class JournalisteEditComponent implements OnInit {
  compte: Compte = new Compte();
  adresse: Adresse = new Adresse();

  constructor(
    private aR: ActivatedRoute,
    private journalisteService: JournalisteService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.journalisteService.get(params['id']).subscribe((result) => {
          this.compte = result;
          this.adresse = result.adresse;
        });
      }
      this.compte.adresse = this.adresse;
    });
  }

  save() {
    if (this.compte.id) {
      this.journalisteService.update(this.compte).subscribe((result) => {
        this.goList();
      });
    } else {
      this.journalisteService.create(this.compte).subscribe((result) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigateByUrl('/journaliste');
  }
}
