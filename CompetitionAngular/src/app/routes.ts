import { GuardJournalisteService } from './services/guard-journaliste.service';
import { EditProfilComponent } from './component/login/profil/edit-profil/edit-profil.component';
import { ParticipantComponent } from './component/epreuve/participant/participant.component';
import { GuardService } from './services/guard.service';
import { ReservationEditComponent } from './component/reservation/reservation-edit/reservation-edit.component';
import { ReservationAccueilComponent } from './component/reservation/reservation-accueil/reservation-accueil.component';
import { VisiteurComponent } from './component/visiteur/visiteur.component';
import { EpreuveComponent } from './component/epreuve/epreuve/epreuve.component';
import { ArticleLectureComponent } from './component/article/article-lecture/article-lecture.component';
import { EpreuveAccueiComponent } from './component/epreuve/epreuve-accuei/epreuve-accuei.component';
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
import { TerrainAccueilComponent } from './component/terrain/terrain-accueil/terrain-accueil.component';
import { TerrainEditComponent } from './component/terrain/terrain-edit/terrain-edit.component';
import { ArticleAccueilComponent } from './component/article/article-accueil/article-accueil.component';
import { ArticleEditComponent } from './component/article/article-edit/article-edit.component';
import { Routes } from '@angular/router';
import { EvenementComponent } from './component/evenement/evenement/evenement.component';

export const routes: Routes = [
  { path: 'athlete', component: AthleteAccueilComponent },
  { path: 'athlete/edit', component: AthleteEditComponent },
  { path: 'athlete/edit/:id', component: AthleteEditComponent },
  { path: 'athlete/:id/epreuve', component: AthleteEpreuveComponent },
  { path: 'athlete/:id/reservation', component: AthleteReservationComponent },
  { path: 'home', component: HomeComponent },
  { path: 'visiteur', component: VisiteurComponent },

  { path: 'logement', component: LogementComponent },
  { path: 'logement/edit', component: EditLogementComponent },
  { path: 'logement/edit/:id', component: EditLogementComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'evenement', component: EvenementAccueilComponent },
  { path: 'evenement/list', component: ListEvenementComponent },
  { path: 'evenement/edit/:id', component: EditEvenementComponent },
  { path: 'evenement/edit', component: EditEvenementComponent },
  { path: 'evenement/consulter', component: EvenementComponent },
  { path: 'epreuve', component: EpreuveAccueiComponent },
  { path: 'epreuve/consulter', component: EpreuveComponent },
  { path: 'epreuve/list', component: ListEpreuveComponent },
  { path: 'epreuve/edit/:id', component: EditEpreuveComponent },
  { path: 'epreuve/edit', component: EditEpreuveComponent },
  { path: 'epreuve/participants', component: ParticipantComponent },
  { path: 'profil', component: EditProfilComponent },
  { path: 'organisateur', component: OrganisateurAccueilComponent },
  { path: 'organisateur/edit', component: OrganisateurEditComponent },
  { path: 'organisateur/edit/:id', component: OrganisateurEditComponent },
  {
    path: 'organisateur/:id/reservation',
    component: OrganisateurReservationComponent,
  },

  {
    path: 'spectateur',
    component: SpectateurAccueilComponent,
    canActivate: [GuardService],
  },
  {
    path: 'spectateur/edit',
    component: SpectateurEditComponent,
    canActivate: [GuardService],
  },
  {
    path: 'spectateur/edit/:id',
    component: SpectateurEditComponent,
    canActivate: [GuardService],
  },
  {
    path: 'spectateur/:id/reservation',
    component: SpectateurReservationComponent,
    canActivate: [GuardService],
  },

  {
    path: 'journaliste',
    component: JournalisteAccueilComponent,
    canActivate: [GuardService],
  },
  {
    path: 'journaliste/edit',
    component: JournalisteEditComponent,
    canActivate: [GuardService],
  },
  {
    path: 'journaliste/edit/:id',
    component: JournalisteEditComponent,
    canActivate: [GuardService],
  },
  {
    path: 'journaliste/:id/reservation',
    component: JournalisteReservationComponent,
    canActivate: [GuardService],
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
  {
    path: 'terrain',
    component: TerrainAccueilComponent,
    canActivate: [GuardService],
  },
  {
    path: 'terrain/edit',
    component: TerrainEditComponent,
    canActivate: [GuardService],
  },
  {
    path: 'terrain/edit/:id',
    component: TerrainEditComponent,
    canActivate: [GuardService],
  },

  {
    path: 'reservation',
    component: ReservationAccueilComponent,
  },
  {
    path: 'reservation/edit',
    component: ReservationEditComponent,
  },
  {
    path: 'reservation/edit/:id',
    component: ReservationEditComponent,
  },
  {
    path: 'reservation/epreuve/:idEpreuve',
    component: ReservationEditComponent,
  },
  { path: 'terrain', component: TerrainAccueilComponent },
  { path: 'terrain/edit', component: TerrainEditComponent },
  { path: 'terrain/edit/:id', component: TerrainEditComponent },
  { path: 'article', component: ArticleAccueilComponent },
  { path: 'article/read/:id', component: ArticleLectureComponent },
  {
    path: 'article/edit',
    component: ArticleEditComponent,
    canActivate: [GuardJournalisteService],
  },
  {
    path: 'article/edit/:id',
    component: ArticleEditComponent,
    canActivate: [GuardJournalisteService],
  },
];
