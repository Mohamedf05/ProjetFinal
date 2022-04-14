import { Router } from '@angular/router';
import { Evenement } from './../../../model/evenement';
import { EvenementService } from './../../../services/evenement.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-evenement',
  templateUrl: './evenement.component.html',
  styleUrls: ['./evenement.component.css'],
})
export class EvenementComponent implements OnInit {
  evenement: Evenement = new Evenement();

  role: string | undefined = localStorage.getItem('role')!;

  constructor(
    private evenementService: EvenementService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.evenement = JSON.parse(localStorage.getItem('evenement')!);
  }
  modifier(): void {
    this.router.navigateByUrl('/evenement/edit/' + this.evenement.id);
  }
  delete(id?: number | undefined): void {
    this.evenementService.delete(id!).subscribe(() => {
      this.router.navigateByUrl('/evenement');
      this.ngOnInit();
    });
  }
}
