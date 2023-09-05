import { Component,  OnInit } from '@angular/core';
import { CD } from 'src/app/models/cd';
import { Observable } from 'rxjs';
import { CdsService } from '../services/cds.service';

@Component({
  selector: 'app-liste-cd',
  templateUrl: './liste-cd.component.html',
  styleUrls: ['./liste-cd.component.scss']
})
export class ListeCDComponent implements OnInit {
  listeCD!: Observable<CD[]>;

  constructor(private cdsService: CdsService) { }

  ngOnInit() : void {

  this.listeCD = this.cdsService.getListeCD();
}
}
