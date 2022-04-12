import { SpectateurService } from './../../../services/spectateur.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-spectateur-accueil',
  templateUrl: './spectateur-accueil.component.html',
  styleUrls: ['./spectateur-accueil.component.css'],
})
export class SpectateurAccueilComponent implements OnInit {
  spectateurs: any[] = [];
  constructor(private spectateurService: SpectateurService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.spectateurService.getAll().subscribe((result) => {
      this.spectateurs = result;
    });
  }

  delete(id: number) {
    this.spectateurService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }
}
