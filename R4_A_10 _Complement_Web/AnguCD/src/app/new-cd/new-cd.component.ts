import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs';
import { CD } from '../models/cd';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-new-cd',
  templateUrl: './new-cd.component.html',
  styleUrls: ['./new-cd.component.scss']
})
export class NewCDComponent {
  formulaire!: FormGroup;
  currentCD$!: Observable<CD>;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    let thumbRegex = new RegExp('https?:\/\/.*\.(?:png|jpg|jpeg|gif|svg|webp)$');

    this.formulaire = this.formBuilder.group({

      title: [null, [Validators.required, Validators.minLength(3)]],
      author: [null, [Validators.required, Validators.minLength(1)]],
      price: [null, [Validators.required, Validators.min(1)]],
      thumbnail: [null, [Validators.required, Validators.pattern(thumbRegex)]],
      dateDeSortie: [null, [Validators.required, Validators.min(10)]],
      quantite: [null, [Validators.required, Validators.min(1)]],

    }, {
      updateOn: 'blur'
    });

    this.currentCD$ = this.formulaire.valueChanges.pipe(map(formValue => (
      {
        id: 0,
        title: formValue.title,
        author: formValue.author,
        price: formValue.price,
        thumbnail: formValue.thumbnail,
        dateDeSortie: formValue.dateDeSortie,
        quantite: formValue.quantite,
      }
    )))

  }

  addCD(){
    console.log(this.formulaire.value);
  }

}
