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
  evenements: Evenement[] = [];

  constructor(
    private evenementService: EvenementService,
    private aR: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.evenementService.getAll().subscribe((result) => {
      this.evenements = result;
    });
  }

  delete(id?: number | undefined): void {
    this.evenementService.delete(id!).subscribe((result) => {
      this.router.navigateByUrl('/evenement/list');
      this.ngOnInit();
    });
  }
  get role() {
    return localStorage.getItem('role');
  }
}
