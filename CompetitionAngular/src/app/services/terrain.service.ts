import { Terrain } from './../model/terrain';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class TerrainService {
  private static URL: string = 'http://localhost:8080/compet/api/terrain';
  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(TerrainService.URL);
  }

  public get(id: number): Observable<any> {
    return this.http.get<any>(`${TerrainService.URL}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<any>(`${TerrainService.URL}/${id}`);
  }

  public create(terrain: any): Observable<any> {
    return this.http.post(TerrainService.URL, terrain);
  }
}
