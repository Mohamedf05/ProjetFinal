import { Compte } from './compte';
export class Article {
  public constructor(
    private _id?: number | undefined,
    private _titre?: string | undefined,
    private _corps?: string | undefined,
    private _image?: string | undefined,
    private _date?: Date | undefined,
    private _journaliste?: Compte | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get titre(): string | undefined {
    return this._titre;
  }

  public set titre(value: string | undefined) {
    this._titre = value;
  }

  public get corps(): string | undefined {
    return this._corps;
  }

  public set corps(value: string | undefined) {
    this._corps = value;
  }

  public get image(): string | undefined {
    return this._image;
  }

  public set image(value: string | undefined) {
    this._image = value;
  }

  public get date(): Date | undefined {
    return this._date;
  }

  public set date(value: Date | undefined) {
    this._date = value;
  }

  public get journaliste(): Compte | undefined {
    return this._journaliste;
  }

  public set journaliste(value: Compte | undefined) {
    this._journaliste = value;
  }
}
