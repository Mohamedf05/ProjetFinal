import { ActivatedRoute, Router } from '@angular/router';
import { EvenementService } from './../../../services/evenement.service';
import { Evenement } from '../../../model/evenement';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-evenement',
  templateUrl: './list-evenement.component.html',
  styleUrls: ['./list-evenement.component.css'],
})
export class ListEvenementComponent implements OnInit {
  evenements: any[] = [];

  constructor(
    private evenementService: EvenementService,
    private aR: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.evenementService.getAll().subscribe((result) => {
      this.evenements = result;
    });
    localStorage.removeItem('evenement');
  }

  consulter(evenement: any): void {
    localStorage.setItem('evenement', JSON.stringify(evenement));

    this.router.navigateByUrl('/evenement/consulter');
  }
  get role() {
    return localStorage.getItem('role');
  }
}
