import { Injectable } from '@angular/core';
import { CD } from '../models/cd';
import { HttpClient } from '@angular/common/http';
import { map, Observable, switchMap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CdsService {

  constructor(private http: HttpClient ) { }

  getListeCD() : Observable<CD[]> {
    return this.http.get<CD[]>("http://localhost:3000/CD");
  }

  getCDById(id: number): Observable<CD> {
    const cd = this.http.get<CD>("http://localhost:3000/CD/" + id);

    if (cd!==undefined) {
      return cd;
    } else {
      throw new Error('Le CD n\'existe pas');
    } 
  }

  newAddCD(cd: CD): Observable<CD> {
    return this.getListeCD.pipe() {
      map(cds => [...cds].sort((a, b) => a.id - b.id));
      map(cds_tries => cds_tries[cds_tries.length - 1]);
      map(dernier_cd => cd.id = dernier_cd.id + 1);
      switchMap(cd => this.http.post<CD>("http://localhost:3000/CD", cd))
    };
  }
}
