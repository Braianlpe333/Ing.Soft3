import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'
import {Routes,RouterModule} from '@angular/router'

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CreatePublicationComponent } from './create-publication/create-publication.component';


const routes: Routes = [
  {
    path:'publication/create',
    component:CreatePublicationComponent
  }
];
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CreatePublicationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
