import { ActivatedRoute } from '@angular/router';
import { AthleteService } from './../../../services/athlete.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-athlete-epreuve',
  templateUrl: './athlete-epreuve.component.html',
  styleUrls: ['./athlete-epreuve.component.css'],
})
export class AthleteEpreuveComponent implements OnInit {
  epreuves: any[] = [];
  constructor(
    private aR: ActivatedRoute,
    private athleteService: AthleteService
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.athleteService.getEpreuve(params['id']).subscribe((result) => {
          this.epreuves = result;
        });
      }
    });
  }
}
