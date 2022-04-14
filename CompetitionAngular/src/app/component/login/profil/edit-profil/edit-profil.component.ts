import { Router } from '@angular/router';
import { Compte } from './../../../../model/compte';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-profil',
  templateUrl: './edit-profil.component.html',
  styleUrls: ['./edit-profil.component.css'],
})
export class EditProfilComponent implements OnInit {
  compte: Compte | undefined;
  role: string | undefined;
  constructor(private router: Router) {}

  ngOnInit(): void {
    localStorage.removeItem('profil');
    this.compte = JSON.parse(localStorage.getItem('compte')!);
    this.role = localStorage.getItem('role')!;
  }

  editer() {
    localStorage.setItem('profil', 'editProfil');
    if (this.role == 'organisateur') {
      this.router.navigateByUrl('/organisateur/edit/' + this.compte?.id);
    } else if (this.role == 'athlete') {
      this.router.navigateByUrl('/athlete/edit/' + this.compte?.id);
    } else if (this.role == 'journaliste') {
      this.router.navigateByUrl('/journaliste/edit/' + this.compte?.id);
    } else {
      this.router.navigateByUrl('/spectateur/edit/' + this.compte?.id);
    }
  }
}
