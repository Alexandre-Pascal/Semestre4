import { Injectable } from '@angular/core';
import { CD } from '../models/cd';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CdsService {

  constructor(private http: HttpClient ) { }

  getListeCD() : Observable<CD[]> {
    return this.http.get<CD[]>("http://localhost:3000/CD");
  }

  getCDById(id: number): CD {
    const cd = this.getListeCD().find(cd => cd.id === id);
    if (cd!==undefined) {
      return cd;
    } else {
      throw new Error('Le CD n\'existe pas');
    } 
  }
}
