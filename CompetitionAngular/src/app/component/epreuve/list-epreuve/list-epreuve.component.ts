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

  delete(id?: number | undefined): void {
    this.epreuveService.delete(id!).subscribe((result) => {
      this.router.navigateByUrl('/epreuve/list');
      this.ngOnInit();
    });
  }
}
