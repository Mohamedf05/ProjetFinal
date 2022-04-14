import { Terrain } from './../../../model/terrain';
import { TerrainService } from './../../../services/terrain.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-terrain-accueil',
  templateUrl: './terrain-accueil.component.html',
  styleUrls: ['./terrain-accueil.component.css'],
})
export class TerrainAccueilComponent implements OnInit {
  terrains: Terrain[] = [];

  constructor(private terrainService: TerrainService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.terrainService.getAll().subscribe((result) => {
      this.terrains = result;
    });
  }

  delete(id: number) {
    this.terrainService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }

  get role() {
    return localStorage.getItem('role');
  }
}
