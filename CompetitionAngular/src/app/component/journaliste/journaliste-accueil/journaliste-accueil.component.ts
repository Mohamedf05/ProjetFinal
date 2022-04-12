import { JournalisteService } from './../../../services/journaliste.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-journaliste-accueil',
  templateUrl: './journaliste-accueil.component.html',
  styleUrls: ['./journaliste-accueil.component.css'],
})
export class JournalisteAccueilComponent implements OnInit {
  journalistes: any[] = [];
  constructor(private journalisteService: JournalisteService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.journalisteService.getAll().subscribe((result) => {
      this.journalistes = result;
    });
  }

  delete(id: number) {
    this.journalisteService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }
}
