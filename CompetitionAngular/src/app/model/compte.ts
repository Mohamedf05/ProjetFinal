import { Adresse } from './adresse';
export class Compte {
  public constructor(
    private _id?: number | undefined,
    private _nom?: string | undefined,
    private _prenom?: string | undefined,
    private _mail?: string | undefined,
    private _dateNaissance?: Date | undefined,
    private _entreprise?: string | undefined,
    private _raisonSoc?: string | undefined,
    private _adresse?: Adresse | undefined
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

  public get prenom(): string | undefined {
    return this._prenom;
  }

  public set prenom(value: string | undefined) {
    this._prenom = value;
  }

  public get mail(): string | undefined {
    return this._mail;
  }

  public set mail(value: string | undefined) {
    this._mail = value;
  }

  public get dateNaissance(): Date | undefined {
    return this._dateNaissance;
  }

  public set dateNaissance(value: Date | undefined) {
    this._dateNaissance = value;
  }

  public get entreprise(): string | undefined {
    return this._entreprise;
  }

  public set entreprise(value: string | undefined) {
    this._entreprise = value;
  }

  public get raisonSoc(): string | undefined {
    return this._raisonSoc;
  }

  public set raisonSoc(value: string | undefined) {
    this._raisonSoc = value;
  }

  public get adresse(): Adresse | undefined {
    return this._adresse;
  }

  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }
}
