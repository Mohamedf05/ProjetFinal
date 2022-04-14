import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-banniere',
  templateUrl: './banniere.component.html',
  styleUrls: ['./banniere.component.css'],
})
export class BanniereComponent implements OnInit {
  constructor(private authService: AuthService) {}

  ngOnInit(): void {}
  get role() {
    return localStorage.getItem('role');
  }
  isAutenticated() {
    return this.authService.isAutenticated();
  }
}
