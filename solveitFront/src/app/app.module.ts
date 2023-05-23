import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'
import {Routes,RouterModule} from '@angular/router'

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CreatePublicationComponent } from './create-publication/create-publication.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RegistroComponent } from './registro/registro.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  {
    path:'publication/create',
    component:CreatePublicationComponent
  },
  {
    path:'',
    component:HomePageComponent
  }
  ,
  {
    path:'regitro',
    component:RegistroComponent
  }
  ,
  {
    path:'login',
    component:LoginComponent
  }
];
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CreatePublicationComponent,
    HomePageComponent,
    RegistroComponent,
    LoginComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
