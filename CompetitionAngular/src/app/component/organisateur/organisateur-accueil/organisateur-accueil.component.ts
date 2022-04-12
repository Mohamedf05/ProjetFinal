import { OrganisateurService } from './../../../services/organisateur.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-organisateur-accueil',
  templateUrl: './organisateur-accueil.component.html',
  styleUrls: ['./organisateur-accueil.component.css'],
})
export class OrganisateurAccueilComponent implements OnInit {
  organisateurs: any[] = [];
  constructor(private organisateurService: OrganisateurService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.organisateurService.getAll().subscribe((result) => {
      this.organisateurs = result;
    });
  }

  delete(id: number) {
    this.organisateurService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }
}
