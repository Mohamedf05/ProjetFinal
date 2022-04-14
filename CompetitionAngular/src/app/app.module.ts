import { ReservationEditComponent } from './component/reservation/reservation-edit/reservation-edit.component';
import { ReservationAccueilComponent } from './component/reservation/reservation-accueil/reservation-accueil.component';
import { ListEvenementComponent } from './component/evenement/list-evenement/list-evenement.component';
import { EditEvenementComponent } from './component/evenement/edit-evenement/edit-evenement.component';
import { routes } from './routes';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { LoginComponent } from './component/login/login.component';
import { OrganisateurAccueilComponent } from './component/organisateur/organisateur-accueil/organisateur-accueil.component';
import { AthleteAccueilComponent } from './component/athlete/athlete-accueil/athlete-accueil.component';
import { SpectateurAccueilComponent } from './component/spectateur/spectateur-accueil/spectateur-accueil.component';
import { JournalisteAccueilComponent } from './component/journaliste/journaliste-accueil/journaliste-accueil.component';
import { EvenementAccueilComponent } from './component/evenement/evenement-accueil/evenement-accueil.component';
import { LogementComponent } from './component/logement/logement/logement.component';
import { TerrainAccueilComponent } from './component/terrain/terrain-accueil/terrain-accueil.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AuthInterceptor } from './interceptor/auth.interceptor';
import { InscriptionAthleteComponent } from './component/inscription-athlete/inscription-athlete.component';
import { InscriptionOrganisateurComponent } from './component/inscription-organisateur/inscription-organisateur.component';
import { InscriptionSpectateurComponent } from './component/inscription-spectateur/inscription-spectateur.component';
import { InscriptionJournalisteComponent } from './component/inscription-journaliste/inscription-journaliste.component';
import { AthleteEditComponent } from './component/athlete/athlete-edit/athlete-edit.component';
import { OrganisateurEditComponent } from './component/organisateur/organisateur-edit/organisateur-edit.component';
import { SpectateurEditComponent } from './component/spectateur/spectateur-edit/spectateur-edit.component';
import { JournalisteEditComponent } from './component/journaliste/journaliste-edit/journaliste-edit.component';
import { AthleteReservationComponent } from './component/athlete/athlete-reservation/athlete-reservation.component';
import { AthleteEpreuveComponent } from './component/athlete/athlete-epreuve/athlete-epreuve.component';
import { OrganisateurReservationComponent } from './component/organisateur/organisateur-reservation/organisateur-reservation.component';
import { SpectateurReservationComponent } from './component/spectateur/spectateur-reservation/spectateur-reservation.component';
import { JournalisteReservationComponent } from './component/journaliste/journaliste-reservation/journaliste-reservation.component';
import { EditLogementComponent } from './component/logement/edit-logement/edit-logement.component';
import { IncaseComponent } from './component/evenement/incase/incase.component';
import { ListEpreuveComponent } from './component/epreuve/list-epreuve/list-epreuve.component';
import { EpreuveAccueiComponent } from './component/epreuve/epreuve-accuei/epreuve-accuei.component';
import { EditEpreuveComponent } from './component/epreuve/edit-epreuve/edit-epreuve.component';
import { TerrainEditComponent } from './component/terrain/terrain-edit/terrain-edit.component';
import { ArticleEditComponent } from './component/article/article-edit/article-edit.component';
import { ArticleAccueilComponent } from './component/article/article-accueil/article-accueil.component';
import { EvenementComponent } from './component/evenement/evenement/evenement.component';
import { EpreuveComponent } from './component/epreuve/epreuve/epreuve.component';
import { ArticleLectureComponent } from './component/article/article-lecture/article-lecture.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BanniereComponent } from './component/banniere/banniere.component';
import { ParticipantComponent } from './component/epreuve/participant/participant.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PageNotFoundComponent,
    InscriptionComponent,
    LoginComponent,
    OrganisateurAccueilComponent,
    AthleteAccueilComponent,
    SpectateurAccueilComponent,
    JournalisteAccueilComponent,
    EvenementAccueilComponent,
    LogementComponent,
    TerrainAccueilComponent,
    InscriptionAthleteComponent,
    InscriptionOrganisateurComponent,
    InscriptionSpectateurComponent,
    InscriptionJournalisteComponent,
    AthleteEditComponent,
    OrganisateurEditComponent,
    SpectateurEditComponent,
    JournalisteEditComponent,
    AthleteReservationComponent,
    AthleteEpreuveComponent,
    OrganisateurReservationComponent,
    SpectateurReservationComponent,
    JournalisteReservationComponent,
    EditLogementComponent,
    IncaseComponent,
    EditEvenementComponent,
    ListEvenementComponent,
    ListEpreuveComponent,
    EpreuveAccueiComponent,
    EditEpreuveComponent,
    TerrainEditComponent,
    ArticleEditComponent,
    ArticleAccueilComponent,
    EvenementComponent,
    EpreuveComponent,
    ArticleLectureComponent,
    BanniereComponent,
    ReservationAccueilComponent,
    ReservationEditComponent,
    ParticipantComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    NgbModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
