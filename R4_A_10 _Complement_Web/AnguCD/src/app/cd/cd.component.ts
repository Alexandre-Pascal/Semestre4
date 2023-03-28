import { Component, Input, OnInit } from '@angular/core';
import { CD } from 'src/app/models/cd';
import { CdsService } from '../services/cds.service';
import { Router, ActivatedRoute } from '@angular/router';




@Component({
  selector: 'app-cd',
  templateUrl: './cd.component.html',
  styleUrls: ['./cd.component.scss']
})
export class CdComponent implements OnInit{
  @Input() Cd!: CD; //reçu par le template listecd
  unCd!: CD; //reçu par le template listecd

  constructor(private cdsService: CdsService, private route: ActivatedRoute) { }

  ngOnInit() : void {
    const idCd = this.route.snapshot.params['id'];
    
    if (idCd===undefined){
      this.unCd = this.Cd;
    }
    else{
      this.unCd = this.cdsService.getCDById(+idCd);
    }

  }
  
  onAddCd(){
    this.Cd.quantite++;
  }
}
