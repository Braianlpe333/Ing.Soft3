import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn = false;

  login() {
    this.isLoggedIn = true;
    sessionStorage.setItem('isLoggedIn', String(this.isLoggedIn));
  }

  logout() {
    // Lógica para cerrar sesión
    this.isLoggedIn = false;
    sessionStorage.setItem('isLoggedIn', String(this.isLoggedIn));
  }
  getIsLoggedIn(){
    return this.isLoggedIn =  (sessionStorage.getItem('isLoggedIn')== "true");
  }
}
