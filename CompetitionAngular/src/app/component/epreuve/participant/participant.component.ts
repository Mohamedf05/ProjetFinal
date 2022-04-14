import { Compte } from './../../../model/compte';
import { EpreuveService } from './../../../services/epreuve.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-participant',
  templateUrl: './participant.component.html',
  styleUrls: ['./participant.component.css'],
})
export class ParticipantComponent implements OnInit {
  athletes: Compte[] = [];
  constructor(private epreuveService: EpreuveService) {}

  ngOnInit(): void {
    this.epreuveService.getAthletes().subscribe((result) => {
      this.athletes = result;
    });
  }
}
