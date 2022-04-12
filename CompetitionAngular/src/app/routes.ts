import { JournalisteReservationComponent } from './component/journaliste/journaliste-reservation/journaliste-reservation.component';
import { SpectateurReservationComponent } from './component/spectateur/spectateur-reservation/spectateur-reservation.component';
import { OrganisateurReservationComponent } from './component/organisateur/organisateur-reservation/organisateur-reservation.component';
import { AthleteReservationComponent } from './component/athlete/athlete-reservation/athlete-reservation.component';
import { AthleteEpreuveComponent } from './component/athlete/athlete-epreuve/athlete-epreuve.component';
import { JournalisteEditComponent } from './component/journaliste/journaliste-edit/journaliste-edit.component';
import { SpectateurEditComponent } from './component/spectateur/spectateur-edit/spectateur-edit.component';
import { OrganisateurEditComponent } from './component/organisateur/organisateur-edit/organisateur-edit.component';
import { AthleteEditComponent } from './component/athlete/athlete-edit/athlete-edit.component';
import { LoginComponent } from './component/login/login.component';
import { InscriptionSpectateurComponent } from './component/inscription-spectateur/inscription-spectateur.component';
import { InscriptionJournalisteComponent } from './component/inscription-journaliste/inscription-journaliste.component';
import { InscriptionOrganisateurComponent } from './component/inscription-organisateur/inscription-organisateur.component';
import { InscriptionAthleteComponent } from './component/inscription-athlete/inscription-athlete.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { JournalisteAccueilComponent } from './component/journaliste/journaliste-accueil/journaliste-accueil.component';
import { SpectateurAccueilComponent } from './component/spectateur/spectateur-accueil/spectateur-accueil.component';
import { OrganisateurAccueilComponent } from './component/organisateur/organisateur-accueil/organisateur-accueil.component';
import { AthleteAccueilComponent } from './component/athlete/athlete-accueil/athlete-accueil.component';
import { EditLogementComponent } from './component/logement/edit-logement/edit-logement.component';
import { LogementComponent } from './component/logement/logement/logement.component';
import { HomeComponent } from './component/home/home.component';
import { EditEpreuveComponent } from './component/epreuve/edit-epreuve/edit-epreuve.component';
import { ListEpreuveComponent } from './component/epreuve/list-epreuve/list-epreuve.component';
import { EditEvenementComponent } from './component/evenement/edit-evenement/edit-evenement.component';
import { EvenementAccueilComponent } from './component/evenement/evenement-accueil/evenement-accueil.component';
import { ListEvenementComponent } from './component/evenement/list-evenement/list-evenement.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'athlete', component: AthleteAccueilComponent },
  { path: 'athlete/edit', component: AthleteEditComponent },
  { path: 'athlete/edit/:id', component: AthleteEditComponent },
  { path: 'athlete/:id/epreuve', component: AthleteEpreuveComponent },
  { path: 'athlete/:id/reservation', component: AthleteReservationComponent },
  { path: 'home', component: HomeComponent },
  { path: 'logement', component: LogementComponent },
  { path: 'logement/edit', component: EditLogementComponent },
  { path: 'logement/edit/:id', component: EditLogementComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'evenement', component: EvenementAccueilComponent },
  { path: 'evenement/list', component: ListEvenementComponent },
  { path: 'evenement/edit/:id', component: EditEvenementComponent },
  { path: 'evenement/edit', component: EditEvenementComponent },
  { path: 'epreuve/list', component: ListEpreuveComponent },
  { path: 'epreuve/edit/:idEvenement', component: EditEpreuveComponent },
  { path: 'epreuve/edit/:id', component: EditEpreuveComponent },

  { path: 'organisateur', component: OrganisateurAccueilComponent },
  { path: 'organisateur/edit', component: OrganisateurEditComponent },
  { path: 'organisateur/edit/:id', component: OrganisateurEditComponent },
  {
    path: 'organisateur/:id/reservation',
    component: OrganisateurReservationComponent,
  },

  { path: 'spectateur', component: SpectateurAccueilComponent },
  { path: 'spectateur/edit', component: SpectateurEditComponent },
  { path: 'spectateur/edit/:id', component: SpectateurEditComponent },
  {
    path: 'spectateur/:id/reservation',
    component: SpectateurReservationComponent,
  },

  { path: 'journaliste', component: JournalisteAccueilComponent },
  { path: 'journaliste/edit', component: JournalisteEditComponent },
  { path: 'journaliste/edit/:id', component: JournalisteEditComponent },
  {
    path: 'journaliste/:id/reservation',
    component: JournalisteReservationComponent,
  },

  { path: 'inscription', component: InscriptionComponent },

  { path: 'inscription/athlete', component: InscriptionAthleteComponent },
  {
    path: 'inscription/organisateur',
    component: InscriptionOrganisateurComponent,
  },
  {
    path: 'inscription/journaliste',
    component: InscriptionJournalisteComponent,
  },
  { path: 'inscription/spectateur', component: InscriptionSpectateurComponent },

  { path: 'login', component: LoginComponent },
];
