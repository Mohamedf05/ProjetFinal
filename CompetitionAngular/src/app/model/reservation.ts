import { Compte } from './compte';
import { Logement } from 'src/app/model/logement';
import { Epreuve } from './epreuve';
import { StatutEvent } from './statut-event';
import { Time } from '@angular/common';

export class Reservation {
  public constructor(
    private _id?: number | undefined,
    private _date?: Date | undefined,
    private _dateDebut?: Date | undefined,
    private _dateFin?: Date | undefined,
    private _heure?: Time | undefined,
    private _statut?: StatutEvent | undefined,
    private _epreuve?: Epreuve | undefined,
    private _logement?: Logement | undefined,
    private _compte?: Compte | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get date(): Date | undefined {
    return this._date;
  }

  public set date(value: Date | undefined) {
    this._date = value;
  }

  public get dateDebut(): Date | undefined {
    return this._dateDebut;
  }

  public set dateDebut(value: Date | undefined) {
    this._dateDebut = value;
  }

  public get dateFin(): Date | undefined {
    return this._dateFin;
  }

  public set dateFin(value: Date | undefined) {
    this._dateFin = value;
  }

  public get heure(): Time | undefined {
    return this._heure;
  }

  public set heure(value: Time | undefined) {
    this._heure = value;
  }

  public get statut(): StatutEvent | undefined {
    return this._statut;
  }

  public set statut(value: StatutEvent | undefined) {
    this._statut = value;
  }

  public get epreuve(): Epreuve | undefined {
    return this._epreuve;
  }

  public set epreuve(value: Epreuve | undefined) {
    this._epreuve = value;
  }

  public get logement(): Logement | undefined {
    return this._logement;
  }

  public set logement(value: Logement | undefined) {
    this._logement = value;
  }

  public get compte(): Compte | undefined {
    return this._compte;
  }

  public set compte(value: Compte | undefined) {
    this._compte = value;
  }
}
