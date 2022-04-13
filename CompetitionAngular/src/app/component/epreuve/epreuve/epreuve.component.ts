import { Epreuve } from './../../../model/epreuve';
import { Router, ActivatedRoute } from '@angular/router';
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

  constructor(
    private epreuveService: EpreuveService,
    private router: Router,
    private aR: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((param) => {
      this.epreuveService.get(param['id']).subscribe((result) => {
        this.epreuve = result;
      });
    });
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
