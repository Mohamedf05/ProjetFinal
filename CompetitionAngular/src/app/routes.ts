import { EditLogementComponent } from './component/logement/edit-logement/edit-logement.component';
import { LogementComponent } from './component/logement/logement/logement.component';
import { HomeComponent } from './component/home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'logement', component: LogementComponent },
  { path: 'logement/edit', component: EditLogementComponent },
  { path: 'logement/edit/:id', component: EditLogementComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
