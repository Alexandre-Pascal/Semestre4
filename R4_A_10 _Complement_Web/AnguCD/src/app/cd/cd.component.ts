import { Component, Input } from '@angular/core';
import { CD } from 'src/app/models/cd';


@Component({
  selector: 'app-cd',
  templateUrl: './cd.component.html',
  styleUrls: ['./cd.component.scss']
})
export class CdComponent {
  @Input() Cd!: CD;

  onAddCd(){
    this.Cd.quantite++;
  }
}
