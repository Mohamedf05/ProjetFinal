import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-evenement-accueil',
  templateUrl: './evenement-accueil.component.html',
  styleUrls: ['./evenement-accueil.component.css'],
})
export class EvenementAccueilComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}
  ajouter(): void {
    this.router.navigateByUrl('/evenement/edit');
  }
}
