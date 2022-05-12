import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DevocionalReadComponent } from './components/views/devocional/devocional-read/devocional-read.component';
import { HomeComponent } from './components/views/home/home.component';

const routes: Routes = [
{
  path: '',
  component: HomeComponent
},
{
  path: 'devocional',
  component: DevocionalReadComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
