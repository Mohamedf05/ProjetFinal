import { Router } from '@angular/router';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  public constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  get login() {
    return localStorage.getItem('login');
  }

  get role() {
    return localStorage.getItem('role');
  }

  isAutenticated() {
    return this.authService.isAutenticated();
  }

  fonctionClicO() {
    if (!this.isAutenticated()) {
      this.router.navigateByUrl('/inscription/organisateur');
    } else if (localStorage.getItem('role') == 'organisateur') {
      this.router.navigateByUrl('/organisateur');
    } else {
      this.router.navigateByUrl('/home');
    }
  }
  fonctionClicA() {
    if (!this.isAutenticated()) {
      this.router.navigateByUrl('/inscription/athlete');
    } else if (localStorage.getItem('role') == 'athlete') {
      this.router.navigateByUrl('/athlete');
    } else {
      this.router.navigateByUrl('/home');
    }
  }

  ngOnInit(): void {}
}
