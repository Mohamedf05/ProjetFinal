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

  get login() {
    return localStorage.getItem('login');
  }

  isAutenticated() {
    return this.authService.isAutenticated();
  }

  logout() {
    localStorage.clear();
  }
}
