import { EvenementService } from './../../../services/evenement.service';
import { Evenement } from '../../../model/evenement';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'evenement-incase',
  templateUrl: './incase.component.html',
  styleUrls: ['./incase.component.css'],
})
export class IncaseComponent implements OnInit {
  evenements: Evenement[] = [];

  constructor(private EvenementService: EvenementService) {}

  ngOnInit(): void {
    this.list();
  }
  list() {
    this.EvenementService.getAll().subscribe((result) => {
      this.evenements = result;
    });
  }
}
