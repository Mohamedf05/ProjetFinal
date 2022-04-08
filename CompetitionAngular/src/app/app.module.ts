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
import { EpreuveComponent } from './component/epreuve/epreuve/epreuve.component';
import { EvenementAccueilComponent } from './component/evenement/evenement-accueil/evenement-accueil.component';
import { LogementComponent } from './component/logement/logement/logement.component';
import { TerrainAccueilComponent } from './component/terrain/terrain-accueil/terrain-accueil.component';
import { ReservationAccueilComponent } from './component/reservation-accueil/reservation-accueil.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AuthInterceptor } from './interceptor/auth.interceptor';

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
    EpreuveComponent,
    EvenementAccueilComponent,
    LogementComponent,
    TerrainAccueilComponent,
    ReservationAccueilComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
