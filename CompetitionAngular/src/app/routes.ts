import { EditEpreuveComponent } from './component/epreuve/edit-epreuve/edit-epreuve.component';
import { ListEpreuveComponent } from './component/epreuve/list-epreuve/list-epreuve.component';
import { EditEvenementComponent } from './component/evenement/edit-evenement/edit-evenement.component';
import { EvenementAccueilComponent } from './component/evenement/evenement-accueil/evenement-accueil.component';
import { ListEvenementComponent } from './component/evenement/list-evenement/list-evenement.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'evenement', component: EvenementAccueilComponent },
  { path: 'evenement/list', component: ListEvenementComponent },
  { path: 'evenement/edit/:id', component: EditEvenementComponent },
  { path: 'evenement/edit', component: EditEvenementComponent },
  { path: 'epreuve/list', component: ListEpreuveComponent },
  { path: 'epreuve/edit/:idEvenement', component: EditEpreuveComponent },
  { path: 'epreuve/edit/:id', component: EditEpreuveComponent },
];
