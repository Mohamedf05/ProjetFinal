import { AthleteService } from './../../../services/athlete.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-athlete-accueil',
  templateUrl: './athlete-accueil.component.html',
  styleUrls: ['./athlete-accueil.component.css'],
})
export class AthleteAccueilComponent implements OnInit {
  athletes: any[] = [];
  constructor(private athleteService: AthleteService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.athleteService.getAll().subscribe((result) => {
      this.athletes = result;
    });
  }

  delete(id: number) {
    this.athleteService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }
}
