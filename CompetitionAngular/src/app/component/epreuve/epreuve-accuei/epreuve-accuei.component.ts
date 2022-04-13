import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-epreuve-accuei',
  templateUrl: './epreuve-accuei.component.html',
  styleUrls: ['./epreuve-accuei.component.css'],
})
export class EpreuveAccueiComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}
  ajouter(): void {
    this.router.navigateByUrl('/epreuve/edit');
  }
}
