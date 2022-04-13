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
    this.evenementService
      .getbyName(localStorage.getItem('evenement')!)
      .subscribe((ok) => {
        this.evenement = ok;
      });
  }
  modifier(): void {
    this.evenementService
      .getbyName(localStorage.getItem('evenement')!)
      .subscribe((e) => {
        this.router.navigateByUrl('/evenement/edit/' + e.id);
      });
  }
  delete(id?: number | undefined): void {
    this.evenementService.delete(id!).subscribe((result) => {
      this.router.navigateByUrl('/evenement');
      this.ngOnInit();
    });
  }
}
