import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Route } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListeCDComponent } from './liste-cd/liste-cd.component';

const routes: Route[] = [
  {path: '', component: HomeComponent},
  {path: 'liste-cd', component: ListeCDComponent}
  
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],

  exports: [RouterModule]
})
export class AppRoutingModule { }
