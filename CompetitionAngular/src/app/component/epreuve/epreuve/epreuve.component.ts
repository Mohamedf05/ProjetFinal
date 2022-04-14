import { Router } from '@angular/router';
import { Epreuve } from './../../../model/epreuve';
import { EpreuveService } from './../../../services/epreuve.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-epreuve',
  templateUrl: './epreuve.component.html',
  styleUrls: ['./epreuve.component.css'],
})
export class EpreuveComponent implements OnInit {
  epreuve: Epreuve = new Epreuve();
  role: string | undefined = localStorage.getItem('role')!;

  constructor(private epreuveService: EpreuveService, private router: Router) {}

  ngOnInit(): void {
    this.epreuve = JSON.parse(localStorage.getItem('epreuve')!);
  }
  modifier(): void {
    this.router.navigateByUrl('/epreuve/edit/' + this.epreuve.id);
  }
  delete(id?: number | undefined): void {
    this.epreuveService.delete(id!).subscribe((result) => {
      this.router.navigateByUrl('/epreuve');
      this.ngOnInit();
    });
  }
}
