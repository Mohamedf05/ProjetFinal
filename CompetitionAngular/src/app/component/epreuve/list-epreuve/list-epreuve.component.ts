import { Evenement } from './../../../model/evenement';
import { Epreuve } from './../../../model/epreuve';
import { ActivatedRoute, Router } from '@angular/router';
import { EpreuveService } from './../../../services/epreuve.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-epreuve',
  templateUrl: './list-epreuve.component.html',
  styleUrls: ['./list-epreuve.component.css'],
})
export class ListEpreuveComponent implements OnInit {
  epreuves: Epreuve[] = [];

  constructor(
    private epreuveService: EpreuveService,
    private aR: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.epreuveService.getAll().subscribe((result) => {
      this.epreuves = result;
    });
  }
  consulter(epreuve: any): void {
    localStorage.setItem('epreuve', JSON.stringify(epreuve));

    this.router.navigateByUrl('/epreuve/consulter');
  }
}
