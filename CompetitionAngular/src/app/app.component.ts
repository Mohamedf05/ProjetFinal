import { Compte } from './model/compte';
import { AuthService } from './services/auth.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'CompetitionAngular';

  public constructor(private authService: AuthService) {}

  get nom() {
    let compte = localStorage.getItem('compte');
    return JSON.parse(compte!).nom;
  }

  get prenom() {
    let compte = localStorage.getItem('compte');
    return JSON.parse(compte!).prenom;
  }

  get role() {
    return localStorage.getItem('role');
  }

  isAutenticated() {
    return this.authService.isAutenticated();
  }

  logout() {
    localStorage.clear();
  }
}
