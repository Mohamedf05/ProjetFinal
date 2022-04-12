import { StatutEvent } from './statut-event';
export class Evenement {
  constructor(
    private _id?: number | undefined,
    private _nom?: string | undefined,
    private _dateDebut?: Date | undefined,
    private _dateFin?: Date | undefined,
    private _ville?: string | undefined,
    private _statut?: StatutEvent | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }

  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
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

  public get ville(): string | undefined {
    return this._ville;
  }
  public set ville(value: string | undefined) {
    this._ville = value;
  }

  public get statut(): StatutEvent | undefined {
    return this._statut;
  }
  public set statut(value: StatutEvent | undefined) {
    this._statut = value;
  }
}
