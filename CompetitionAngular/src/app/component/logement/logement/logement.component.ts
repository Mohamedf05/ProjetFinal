import { Component, OnInit } from '@angular/core';
import { Logement } from 'src/app/model/logement';
import { LogementService } from 'src/app/services/logement.service';

@Component({
  selector: 'app-logement',
  templateUrl: './logement.component.html',
  styleUrls: ['./logement.component.css'],
})
export class LogementComponent implements OnInit {
  logements: Logement[] = [];

  constructor(private logementService: LogementService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.logementService.getAll().subscribe((result) => {
      this.logements = result;
    });
  }

  delete(id: number) {
    this.logementService.delete(id).subscribe((ok) => {
      this.list();
    });
  }

  get role() {
    return localStorage.getItem('role');
  }
}
