import { Terrain } from './terrain';
import { Discipline } from './discipline';
import { Evenement } from './evenement';
export class Epreuve {
  constructor(
    private _id?: number | undefined,
    private _evenement?: Evenement | undefined,
    private _maxParticipant?: number | undefined,
    private _date?: Date | undefined,
    private _discipline?: Discipline | undefined,
    private _terrain?: Terrain | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  public get evenement(): Evenement | undefined {
    return this._evenement;
  }
  public set evenement(value: Evenement | undefined) {
    this._evenement = value;
  }

  public get maxParticipant(): number | undefined {
    return this._maxParticipant;
  }
  public set maxParticipant(value: number | undefined) {
    this._maxParticipant = value;
  }
  public get date(): Date | undefined {
    return this._date;
  }
  public set date(value: Date | undefined) {
    this._date = value;
  }
  public get discipline(): Discipline | undefined {
    return this._discipline;
  }
  public set discipline(value: Discipline | undefined) {
    this._discipline = value;
  }
  public get terrain(): Terrain | undefined {
    return this._terrain;
  }
  public set terrain(value: Terrain | undefined) {
    this._terrain = value;
  }
}
