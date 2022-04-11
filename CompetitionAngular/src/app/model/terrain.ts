import { TypeTerrain } from './type-terrain';
import { Discipline } from './discipline';
import { Adresse } from './adresse';
export class Terrain {
  public constructor(
    private _id?: number | undefined,
    private _nom?: string | undefined,
    private _adresse?: Adresse | undefined,
    private _disciplines?: Set<Discipline> | undefined,
    private _typeTerrain?: TypeTerrain | undefined
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

  public get adresse(): Adresse | undefined {
    return this._adresse;
  }

  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }

  public get disciplines(): Set<Discipline> | undefined {
    return this._disciplines;
  }

  public set discipline(value: Set<Discipline> | undefined) {
    this._disciplines = value;
  }

  public get typeTerrain(): TypeTerrain | undefined {
    return this._typeTerrain;
  }

  public set typeTerrain(value: TypeTerrain | undefined) {
    this._typeTerrain = value;
  }
}
