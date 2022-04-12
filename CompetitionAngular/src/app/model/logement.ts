import { TypeLogement } from './type-logement';
import { Adresse } from './adresse';
export class Logement {
  public constructor(
    private _id?: number | undefined,
    private _nom?: string | undefined,
    private _adresse?: Adresse | undefined,
    private _typeLogement?: TypeLogement | undefined
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

  public get typeLogement(): TypeLogement | undefined {
    return this._typeLogement;
  }

  public set typeLogement(value: TypeLogement | undefined) {
    this._typeLogement = value;
  }
}
